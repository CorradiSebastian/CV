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

    private fun loadTechnologies(): List<Technology> {
        DBManager.getCvDatabase().technologyDao().deleteAll()

        val  technologyDTO = TechnologyService().getTechnologies()
        val technologies = technologiesFromDTO(technologyDTO)
        DBManager.getCvDatabase().technologyDao().insertAll(technologies)
        return technologies
    }

    private fun technologiesFromDTO(dtos : List<TechnologyDTO> ): List<Technology>
    {
        return dtos.map<TechnologyDTO, Technology> { Technology(it.name, it.description)
        }
    }

    fun getTechnologies(): List<Technology> {
        var technologies = DBManager.getCvDatabase().technologyDao().getAll()
        when (technologies.size){
            0 -> return loadTechnologies()
            else -> return technologies
        }
    }

}