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

    fun getJobs(fileName: String, context: Context): List<Job> {
        val  jobsDTO = JobService().getJobs()
        return jobsFromDTO(jobsDTO)
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
//        val jobs = getJobsFromJson("jobs.json", context)
//        when (experienceId) {
//            1 -> {
//                return jobs[0]
//            }
//            else -> {
//                return jobs[1]
//            }
//        }
        return DBManager.getCvDatabase().jobDao().getJobByExperienceId(experienceId)
    }

    private fun jobsFromDTO(dtos : List<JobDTO> ): List<Job>
    {
        return dtos.map<JobDTO, Job> { Job(it.id, it.name,
            it.companyName, it.description, it.responsibilities, it.technologies,
            it.libraries, it.extras)
        }
    }

    suspend fun loadJobs(){
        val  jobsDTO = JobService().getJobsAsync()
        val jobs = jobsFromDTO(jobsDTO)
        DBManager.getCvDatabase().jobDao().insertAll(jobs)
        Log.d("JobRepository", "Async Check")
    }
}