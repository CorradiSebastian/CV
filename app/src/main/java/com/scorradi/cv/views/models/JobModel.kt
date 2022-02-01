package com.scorradi.cv.views.models

import com.scorradi.cv.db.daos.entities.Job
import java.io.Serializable


class JobModel():Serializable
{
    constructor(id: Int, companyName: String, name:String, responsibilities:String,
                technologies: String, libraries: String, extras: String): this()
    {
        this.id = id
        this.name = name
        this.companyName = companyName
        this.responsibilities = responsibilities
        this.technologies = technologies
        this.libraries = libraries
        this.extras = extras

    }
    constructor(job: Job): this()
    {
        this.id = job.id
        this.name = job.name
        this.companyName = job.role
        this.responsibilities = job.responsibilities
        this.technologies = job.technologies
        this.libraries = job.libraries
        this.extras = job.extras
    }

    var id: Int = 0
    var companyName: String? = null
    var name: String? = null
    var responsibilities: String? = null
    var technologies: String? = null
    var libraries: String? = null
    var extras: String? = null
}