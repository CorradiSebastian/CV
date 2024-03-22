package com.scorradi.cv.views.main

import android.R.attr.capitalize
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.scorradi.cv.R
import com.scorradi.cv.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private val viewModel: MainViewModel by activityViewModels()
    fun getDeviceName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        Log.e("Sebas", "model: ${Build.MODEL}")
        Log.e("Sebas", "device: ${Build.DEVICE}")
        Log.e("Sebas", "soc_model: ${Build.SOC_MODEL}")
        return if (model.toLowerCase().startsWith(manufacturer.toLowerCase())) {
            model
        } else {
            model
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        Log.e("Sebas", getDeviceName())
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

        //ocultar... segun cada caso con destinations
       /* navController.addOnDestinationChangedListener { _, destination, _ ->
            Toast.makeText(applicationContext, "hola carola", Toast.LENGTH_LONG).show()
            /*if(destination.id == R.id.full_screen_destination) {
                toolbar.visibility = View.GONE
                bottomNavigationView.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
                bottomNavigationView.visibility = View.VISIBLE

            }*/
        }*/

        //oculatr cada caso con argumentos de navegacion
        //navController.addOnDestinationChangedListener { _, _, arguments ->
        //bottomNavigationView.isVisible = arguments?.getBoolean("ShowAppBar", false) == true

    }


}
