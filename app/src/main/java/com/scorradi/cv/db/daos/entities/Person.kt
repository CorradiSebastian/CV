package com.scorradi.cv.db.daos.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.scorradi.cv.datamanager.person.SocialNetworkLink
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "persons", foreignKeys = [])
data class Person(var name:String,
                  @PrimaryKey
                  var id:String,
                  var bornDate:Date,
                  var phoneNumber:String,
                  var networkLinks: List<SocialNetworkLink>) {
    constructor(): this("", "", Date(0), "", ArrayList()){}
}