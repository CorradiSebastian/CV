package com.scorradi.cv.datamanager.experience

import android.content.Context
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.DataManager
import com.scorradi.cv.datamanager.ExperienceDTO
import com.scorradi.cv.datamanager.Utils
import com.scorradi.cv.db.daos.entities.Experience
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class ExperienceManager{
    public fun getExperiences(context: Context): List<Experience>{
        return getExperiencesFromJson("experiences.json", context)
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
            experienceDTOs = DataManager.gson.fromJson<ArrayList<ExperienceDTO>>(json.get("experiences").toString(), arrayListType)

        } catch (e: JSONException) {
            return experiencesFromDTO(experienceDTOs)
        }

        return experiencesFromDTO(experienceDTOs)
    }

    private fun experiencesFromDTO(dtos : ArrayList<ExperienceDTO> ): List<Experience>
    {
        return dtos.map<ExperienceDTO, Experience> { Experience(it.id,
            it.companyName, it.jobId, Date(it.from), Date(it.to))}
    }

}