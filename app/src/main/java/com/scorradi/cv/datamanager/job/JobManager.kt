package com.scorradi.cv.datamanager.job

import android.content.Context
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.datamanager.Utils
import com.scorradi.cv.datamanager.service.experience.ExperienceDTO
import com.scorradi.cv.datamanager.service.experience.ExperienceService
import com.scorradi.cv.datamanager.service.job.JobDTO
import com.scorradi.cv.datamanager.service.job.JobService
import com.scorradi.cv.db.DBManager
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Job
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class JobManager {

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
            jobs = DataManager.gson.fromJson<ArrayList<JobDTO>>(json.get("jobs").toString(), arrayListType)

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

    fun loadJobs(){
        val  jobsDTO = JobService().getJobs()
        val jobs = jobsFromDTO(jobsDTO)
        DBManager.getCvDatabase().jobDao().insertAll(jobs)
    }
}