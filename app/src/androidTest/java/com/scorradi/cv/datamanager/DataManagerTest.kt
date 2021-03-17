package com.scorradi.cv.datamanager

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataManagerTest {
    @Test
    fun testLoadExperiences() {
        val dataManager = DataManager()
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val experiencesJson = dataManager.getExperiences(appContext)
        val experiencesMocked = dataManager.getExperiencesMocked()

        Assert.assertEquals(experiencesMocked, experiencesJson)
    }
}