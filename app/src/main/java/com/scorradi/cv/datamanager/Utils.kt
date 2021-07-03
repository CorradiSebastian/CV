package com.scorradi.cv.datamanager

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.reflect.Type

class Utils{
    companion object {
        val gson by lazy { Gson() }

//        fun loadJsonFromFile(filename: String, context: Context): String {
//            GlobalScope.launch {
//
//            }
//        }

        fun loadJsonFromFile(filename: String, context: Context): String {
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


        fun toJson(obj: Any?): String? {
            return gson.toJson(obj)
        }

        inline fun <reified T> fromJson(json: String?): T? {
            return fromJson(json, object : TypeToken<T>() {}.type)
        }

        fun <T> fromJson(json: String?, classOfT: Class<T>): T? {
            return gson.fromJson(json, classOfT)
        }

        fun <T> fromJson(json: String?, typeOfT: Type): T? {
            return gson.fromJson(json, typeOfT)
        }
    }
}