package com.scorradi.cv.datamanager.job

import android.content.Context
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.datamanager.Utils
import com.scorradi.cv.db.daos.entities.Job
import org.json.JSONException
import org.json.JSONObject

class JobManager {

    //TODO use JobDTO
    fun getJobsFromJson(fileName: String, context: Context): List<Job> {
        var jobs = ArrayList<Job>()
        try {
            // Load the JSONArray from the file
            val jsonString = Utils.Companion.loadJsonFromFile(fileName, context)
            val json = JSONObject(jsonString)

            val arrayListType = object : TypeToken<ArrayList<Job?>?>() {}.type
            jobs = DataManager.gson.fromJson<ArrayList<Job>>(json.get("jobs").toString(), arrayListType)

        } catch (e: JSONException) {
            //return jobsFromDTO(jobs)
            return jobs
        }

//        return jobsFromDTO(experienceDTOs)
        return jobs
    }

    fun getJob(context: Context, experienceId: Int): Job {
        val jobs = getJobsFromJson("jobs.json", context)
        if (experienceId == 1){
            return jobs[0]
        } else {
            return jobs[1]
        }
    }
}