package com.scorradi.cv.datamanager


import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.experience.ExperienceManager
import com.scorradi.cv.datamanager.job.JobManager
import com.scorradi.cv.datamanager.person.PersonManager
import com.scorradi.cv.datamanager.person.SocialNetworkLink
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Job
import com.scorradi.cv.db.daos.entities.Person
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class DataManager {
    companion object {
        val gson = Gson()
    }

    private val experienceManager = ExperienceManager()
    private val jobManager = JobManager()
    private val personManager = PersonManager()

    fun getPerson(id: Int): Person? {
        return Person("Sebastian Corradi", Integer.toString(id), Date(321782400000), "15-555-1234", ArrayList<SocialNetworkLink>())
    }

    fun getPerson(): Person {
        return personManager.getPerson()
    }

    fun getExperiences(): List<Experience>{
        //return experienceManager.getExperiencesFromJson("experiences.json", context)
        return experienceManager.getExperiences()
    }

    fun getExperiencesMocked(): List<Experience>{
        return experienceManager.getExperiencesMocked()
    }

    fun getJob(context: Context, experienceId: Int): Job{
        return jobManager.getJob(experienceId)
    }

    fun loadData(){
        personManager.loadPerson()
        jobManager.loadJobs()
        experienceManager.loadExperiences()

    }
}