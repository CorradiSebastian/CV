package com.scorradi.cv.views.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.scorradi.cv.R

import com.scorradi.cv.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_activity_main_container, MainFragment.newInstance())
        transaction.addToBackStack(null)
        transaction.commit()*/

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_host) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

        //binding.bottomNav.setupWithNavController()
        /*
        val controller = tab_bottom_navigation_view.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.tab_nav_host_container,
            intent = requireActivity().intent,
            onDestinationChangedListener = onDestinationChangedListener
        )*/



        //binding.bottomNav.selectedItemId = R.id.nav_home
/*
        //ocultar... segun cada caso con destinations
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.full_screen_destination) {
                toolbar.visibility = View.GONE
                bottomNavigationView.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
                bottomNavigationView.visibility = View.VISIBLE

            }
        }

        //oculatr cada caso con argumentos de navegacion
        navController.addOnDestinationChangedListener { _, _, arguments ->
        bottomNavigationView.isVisible = arguments?.getBoolean("ShowAppBar", false) == true
}
*/


    }
}

