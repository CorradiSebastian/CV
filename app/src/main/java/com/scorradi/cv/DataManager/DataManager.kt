package com.scorradi.cv.DataManager


import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Person
import com.scorradi.cv.views.models.ExperienceModel
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class DataManager {
    companion object {
        val gson = Gson()
    }
    public fun getPerson(id: Int): Person? {
        return Person("Sebastian Corradi", Integer.toString(id), Date(321782400000), "15-555-1234")
    }
    public fun getPerson(): Person {
        return Person("Sebastian Corradi", "12.345.678", Date(321782400000), "15-555-1234")
    }

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
            val jsonString = loadJsonFromFile(fileName, context)
            val json = JSONObject(jsonString)

            val arrayListType = object : TypeToken<ArrayList<ExperienceDTO?>?>() {}.type
            experienceDTOs = gson.fromJson<ArrayList<ExperienceDTO>>(json.get("experiences").toString(), arrayListType)

        } catch (e: JSONException) {
            return experiencesFromDTO(experienceDTOs)
        }

        return experiencesFromDTO(experienceDTOs)
    }

    private fun loadJsonFromFile(filename: String, context: Context): String {
        var json = ""

        try {
            val input = context.assets.open(filename)
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            json = buffer.toString(Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return json
    }

    private fun experiencesFromDTO(dtos : ArrayList<ExperienceDTO> ): List<Experience>
    {
        return dtos.map<ExperienceDTO, Experience> { Experience(it.Id,
                                              it.CompanyName, it.JobId, Date(it.From), Date(it.To))}
    }
}