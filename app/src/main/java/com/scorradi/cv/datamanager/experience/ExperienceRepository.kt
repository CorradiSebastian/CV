package com.scorradi.cv.datamanager.experience

import android.content.Context
import android.util.Log
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.RepositoryManager
import com.scorradi.cv.service.experience.ExperienceDTO
import com.scorradi.cv.datamanager.Utils
import com.scorradi.cv.service.experience.ExperienceService
import com.scorradi.cv.db.DBManager
import com.scorradi.cv.db.daos.entities.Experience
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class ExperienceRepository{
    suspend fun getExperiences(): List<Experience>{
        var experiences = DBManager.getCvDatabase().experienceDao().getAll()
        when (experiences.size){
            0 -> return loadExperiences()
            else -> return experiences
        }
    }

    public fun getExperiencesMocked(): List<Experience>{
        val experience1 = Experience(1, "Google", 2, Date(321742400000), Date(321752400000))
        val experience2 = Experience(2, "Apple", 3, Date(321722400000), Date(321742400000))
        val experiences = ArrayList<Experience>()
        experiences.add(experience1)
        experiences.add(experience2)
        return experiences
    }

    fun getExperiencesFromJson(fileName: String, context: Context): List<Experience> {
        var experienceDTOs = ArrayList<ExperienceDTO>()
        try {
            // Load the JSONArray from the file
            val jsonString = Utils.Companion.loadJsonFromFile(fileName, context)
            val json = JSONObject(jsonString)

            val arrayListType = object : TypeToken<ArrayList<ExperienceDTO?>?>() {}.type
            experienceDTOs = RepositoryManager.gson.fromJson<ArrayList<ExperienceDTO>>(json.get("experiences").toString(), arrayListType)

        } catch (e: JSONException) {
            return experiencesFromDTO(experienceDTOs)
        }

        return experiencesFromDTO(experienceDTOs)
    }

    private fun experiencesFromDTO(dtos : List<ExperienceDTO> ): List<Experience>
    {
        return dtos.map<ExperienceDTO, Experience> { Experience(it.id,
            it.companyName, it.jobId, Date(it.from), Date(it.to))}
    }

    private suspend fun loadExperiences(): List<Experience>{
        val experienceDTOs = ExperienceService().getExperiencesAsync()
        val experiences = experiencesFromDTO(experienceDTOs)
        DBManager.getCvDatabase().experienceDao().insertAll(experiences)
        return experiences
    }
}