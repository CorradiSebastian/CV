package com.scorradi.cv.datamanager.technology

import android.content.Context
import android.util.Log
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.RepositoryManager
import com.scorradi.cv.datamanager.Utils
import com.scorradi.cv.db.DBManager
import com.scorradi.cv.db.daos.entities.Job
import com.scorradi.cv.db.daos.entities.Technology
import com.scorradi.cv.service.job.JobDTO
import com.scorradi.cv.service.job.JobService
import com.scorradi.cv.service.technology.TechnologyDTO
import com.scorradi.cv.service.technology.TechnologyService
import org.json.JSONException
import org.json.JSONObject

class TechnologyRepository {

    fun loadTechnologies(): List<Technology> {
        DBManager.getCvDatabase().technologyDao().deleteAll()

        val  technologyDTO = TechnologyService().getTechnologies()
        val technologies = technologiesFromDTO(technologyDTO)
        DBManager.getCvDatabase().technologyDao().insertAll(technologies)
        Log.d("technologyDao", "Async Check")
        return technologies
    }
/*
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
*/

    private fun technologiesFromDTO(dtos : List<TechnologyDTO> ): List<Technology>
    {
        return dtos.map<TechnologyDTO, Technology> { Technology(it.name, it.description, it.time)
        }
    }

    fun getTechnologies(): List<Technology> {
        return DBManager.getCvDatabase().technologyDao().getAll()
    }

}