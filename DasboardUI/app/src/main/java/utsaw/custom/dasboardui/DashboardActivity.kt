package utsaw.custom.dasboardui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {


    private lateinit var fragmentManager: FragmentManager
    private lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigation = findViewById(R.id.bottom_navigation)

        fragmentManager = supportFragmentManager
        bottomNavigation.selectedItemId = R.id.home


        loadFragment(DashboardFragment())

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> loadFragment(DashboardFragment())
                R.id.travel -> loadFragment(SearchResultFragment())
                R.id.timer -> loadFragment(DashboardFragment())
                R.id.profile -> loadFragment(SearchResultFragment())
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}