package com.scorradi.cv.db.daos.entities

import java.util.*

data class Person(var Name:String, var Id:String, var BornDate:Date, var PhoneNumber:String) {
    constructor(): this("", "", Date(0), ""){}
}