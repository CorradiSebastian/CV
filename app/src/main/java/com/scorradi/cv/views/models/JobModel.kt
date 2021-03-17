package com.scorradi.cv.views.models

import com.scorradi.cv.db.daos.entities.Job
import java.io.Serializable


class JobModel():Serializable
{
    constructor(id: Int, companyName: String, name:String, responsibilities:String): this()
    {
        this.id = id
        this.name = name
        this.companyName = companyName
        this.responsibilities = responsibilities
    }
    constructor(job: Job): this()
    {
        this.id = job.id
        this.name = job.name
        this.companyName = job.companyName
        this.responsibilities = job.responsibilities
    }

    var id: Int = 0
    var companyName: String? = null
    var name: String? = null
    var responsibilities: String? = null
}