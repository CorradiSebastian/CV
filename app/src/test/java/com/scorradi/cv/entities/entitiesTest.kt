package com.scorradi.cv.entities


import com.scorradi.cv.db.daos.entities.Company
import com.scorradi.cv.db.daos.entities.DateComparator
import com.scorradi.cv.db.daos.entities.Job
import junit.framework.Assert.assertTrue
import org.junit.Assert

import org.junit.Test
import java.util.*

class entitiesTest {
    @Test
    fun company() {
        val company = Company(
            "google",
            "leading search engines since ever",
            "Internet",
            "AR"
        )
        assertTrue(company.Name == "google")

        val job = Job(
            1,
            company.Name,
            "ActionScript developer"
        )
        assertTrue(job.CompanyName == company.Name)
        //assertTrue(job.From == Date(2010, 12,12))
        //estos tests son horribles, demasiado pavos
        //armar tests de logica o de los viewmodels, cuando los arma
    }

    @Test
    fun comparator(){
        val dates = mutableListOf(
            Date(2020, 4, 3),
            Date(2021, 5, 16),
            Date(2022, 1, 29)
        )
        assertTrue(DateComparator.compare(dates[0], dates[1]) < 0);
        assertTrue(DateComparator.compare(dates[0], dates[2]) < 0);
        Assert.assertFalse(DateComparator.compare(dates[1], dates[2]) > 0);
/*
        println("--- ASC ---")
        dates.sortedWith(compareBy { it.year }.thenBy { it.month }.thenBy { it.day })
            .forEach { println(it) }
            */
    }

}
