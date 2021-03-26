package com.scorradi.cv.db.daos.entities

import androidx.room.*
import java.util.*

@Entity(tableName = "experiences", foreignKeys = [(
        ForeignKey(
            entity = Company::class,
            parentColumns = ["name"],
            childColumns = ["company_name"])),
    (ForeignKey(
        entity = Job::class,
        parentColumns = ["id"],
        childColumns = ["job_id"]))])

data class Experience(
    @PrimaryKey
    val Id: Int,
    @ColumnInfo(name = "company_name")
    val companyName: String,
    @ColumnInfo(name = "job_id")
    val jobId: Int,
    val from: Date,
    val to: Date
) {

}

class DateComparator {

    companion object : Comparator<Date> {

        override fun compare(a: Date, b: Date): Int = when {
            a.year != b.year -> a.year - b.year
            a.month != b.month -> a.month - b.month
            else -> a.day - b.day
        }
    }
}