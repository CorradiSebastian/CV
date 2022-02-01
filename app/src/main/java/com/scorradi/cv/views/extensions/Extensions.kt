package com.scorradi.cv.views.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.scorradi.cv.CvApplication
import com.scorradi.cv.R
import java.text.SimpleDateFormat
import java.util.*


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun Date.toStringInLocalFormat():String{
        val localFormat = CvApplication.applicationContext().resources.getString(R.string.date_format)
    return toStringInLocalFormat(localFormat)
}

fun Date.toStringInLocalFormat(pattern: String): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(this)
}
