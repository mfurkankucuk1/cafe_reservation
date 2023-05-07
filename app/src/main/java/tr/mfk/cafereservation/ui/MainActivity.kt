package tr.mfk.cafereservation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import tr.mfk.cafereservation.R
import tr.mfk.cafereservation.databinding.ActivityMainBinding
import tr.mfk.cafereservation.ui.utils.gone
import tr.mfk.cafereservation.ui.utils.visible

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()

    }
    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }

    fun bottomNavigationVisibility(isVisible :Boolean){
        with(binding){
            if (isVisible){
                bottomNavigation.visible()
            }else {
                bottomNavigation.gone()
            }
        }
    }

    fun setupBottomNavigationMenu(isMerchant:Boolean) {
        with(binding){
            if (isMerchant){
                bottomNavigation.menu.clear()
                bottomNavigation.inflateMenu(R.menu.menu_merchant);
            }else{
                bottomNavigation.menu.clear()
                bottomNavigation.inflateMenu(R.menu.menu_customer);
            }
        }
    }

}