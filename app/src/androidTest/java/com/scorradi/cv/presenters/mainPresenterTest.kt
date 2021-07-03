package com.scorradi.cv.presenters

import android.app.Application
import androidx.lifecycle.Observer
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.scorradi.cv.db.daos.entities.Experience
import com.scorradi.cv.db.daos.entities.Person
import com.scorradi.cv.views.main.MainViewModel
import com.scorradi.cv.views.models.ExperienceModel
import com.scorradi.cv.views.models.PersonModel
import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.test.TestCoroutineDispatcher
//import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*


class MainViewModelTest{

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var closeable: AutoCloseable

    @Mock
    private lateinit var context: Application

    @Before
    fun initMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @After
    fun closeMocks(){
        closeable.close()
    }

    @Test
    fun testLoadPerson(){
        val mainViewModel = MainViewModel(context);
        val person = Person("Sebastian Corradi", "12.345.678", Date(321782400000), "15-555-1234");
        val personModelExpected: PersonModel = PersonModel(person);
        val personModelActual = mainViewModel.loadPersonModel();
        assertEquals(personModelExpected, personModelActual)
    }

    @Test
    fun testLoadExperiencesFromJson(){
        Mockito.`when`(context.assets).thenReturn((InstrumentationRegistry.getInstrumentation().targetContext
            .applicationContext as Application).assets)

        val mainViewModel = MainViewModel(context);
        val experienceActual = mainViewModel.loadExperienceModels()

        //values taken from experiences.json file
        val experienceExpected = ArrayList<ExperienceModel>(0)
        val experience1 = Experience(1, "Google", 2, Date(321742400000), Date(321752400000))
        val experience2 = Experience(2, "Apple", 3, Date(321722400000), Date(321742400000))
        experienceExpected.add(ExperienceModel(experience1))
        experienceExpected.add(ExperienceModel(experience2))

        assertEquals(experienceExpected, experienceActual)
    }

    fun getExperienceModelArrayMocked():ArrayList<ExperienceModel>{
        //values taken from experiences.json file
        val experienceExpected = ArrayList<ExperienceModel>(0)
        val experience1 = Experience(1, "Google", 2, Date(321742400000), Date(321752400000))
        val experience2 = Experience(2, "Apple", 3, Date(321722400000), Date(321742400000))
        experienceExpected.add(ExperienceModel(experience1))
        experienceExpected.add(ExperienceModel(experience2))

        return experienceExpected;
    }
    @Test
    fun testMainViewModel(){
        Mockito.`when`(context.assets).thenReturn((InstrumentationRegistry.getInstrumentation().targetContext
            .applicationContext as Application).assets)

        val observer = mock<Observer<List<ExperienceModel>>>()

        val vm = MainViewModel(context)
        vm.experiences.observeForever(observer)
        vm.onCreate()

        var list: List<ExperienceModel> = getExperienceModelArrayMocked()

        //var myList = List<ExperienceModel>
        verify(observer).onChanged(list)
        assertEquals(list.size, 2)
    }
}