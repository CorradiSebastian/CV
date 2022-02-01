package com.scorradi.cv.datamanager.job

import android.content.Context
import android.util.Log
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.RepositoryManager
import com.scorradi.cv.datamanager.Utils
import com.scorradi.cv.service.job.JobDTO
import com.scorradi.cv.service.job.JobService
import com.scorradi.cv.db.DBManager
import com.scorradi.cv.db.daos.entities.Job
import org.json.JSONException
import org.json.JSONObject
import kotlin.collections.ArrayList

class JobRepository {

    suspend fun getJobs(): List<Job> {
        val jobs = DBManager.getCvDatabase().jobDao().getAll()
        when (jobs.size){
            0 -> return  loadJobs()
            else -> return jobs
        }
    }

    fun getJobsFromJson(fileName: String, context: Context): List<Job> {
        var jobs = ArrayList<JobDTO>()
        try {
            // Load the JSONArray from the file
            val jsonString = Utils.Companion.loadJsonFromFile(fileName, context)
            val json = JSONObject(jsonString)

            val arrayListType = object : TypeToken<ArrayList<JobDTO?>?>() {}.type
            jobs = RepositoryManager.gson.fromJson<ArrayList<JobDTO>>(json.get("jobs").toString(), arrayListType)

        } catch (e: JSONException) {
            return jobsFromDTO(jobs)
        }

        return jobsFromDTO(jobs)
    }

    fun getJob(experienceId: Int): Job {
        return DBManager.getCvDatabase().jobDao().getJobByExperienceId(experienceId)
    }

    private fun jobsFromDTO(dtos : List<JobDTO> ): List<Job>
    {
        return dtos.map<JobDTO, Job> { Job(it.id, it.name,
            it.companyName, it.description, it.responsibilities, it.technologies,
            it.libraries, it.extras)
        }
    }

    private suspend fun loadJobs(): List<Job>{
        val  jobsDTO = JobService().getJobsAsync()
        val jobs = jobsFromDTO(jobsDTO)
        DBManager.getCvDatabase().jobDao().insertAll(jobs)
        return jobs
    }
}