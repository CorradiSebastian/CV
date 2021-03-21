package com.scorradi.cv.db.daos.entities

import java.util.*

data class Person(var name:String,
                  var id:String,
                  var bornDate:Date,
                  var phoneNumber:String) {
    constructor(): this("", "", Date(0), ""){}
}