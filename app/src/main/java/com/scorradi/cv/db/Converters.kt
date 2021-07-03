package com.scorradi.cv.db

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.scorradi.cv.datamanager.Utils
import com.scorradi.cv.datamanager.person.SocialNetworkLink
import java.lang.reflect.Type
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromLinkJson(json: String?): SocialNetworkLink? {
        return Utils.fromJson(json, SocialNetworkLink::class.java)
    }

    @TypeConverter
    fun socialNetworkLinkToJson(socialNetworkLink: SocialNetworkLink?): String? {
        return Utils.toJson(socialNetworkLink)
    }

    @TypeConverter
    fun fromLinkArrayJson(json: String?): List<SocialNetworkLink>? {
        val listType: Type = object : TypeToken<List<SocialNetworkLink>?>() {}.type

        return Utils.fromJson(json = json)
    }

    @TypeConverter
    fun socialNetworkLinkArrayToJson(socialNetworkLinks: List<SocialNetworkLink>?): String? {
        return Utils.toJson(socialNetworkLinks)
    }
}