package com.scorradi.cv.datamanager

import android.content.Context
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

class Utils{
    companion object {


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
    }
}