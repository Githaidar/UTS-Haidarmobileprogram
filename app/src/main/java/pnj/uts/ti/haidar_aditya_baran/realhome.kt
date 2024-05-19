package pnj.uts.ti.haidar_aditya_baran

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class realhome : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager // Declare FragmentManager using lateinit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_realhome)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        fragmentManager = supportFragmentManager
        replaceFragment(fragmentHome())

        // Find your three buttons by their IDs (replace with your actual IDs)
        val btnFragmentHome = findViewById<View>(R.id.home)
        val btnFragmentA = findViewById<View>(R.id.berita)
        val btnFragmentB = findViewById<View>(R.id.profile)

        // Set click listeners for buttons
        btnFragmentHome.setOnClickListener { replaceFragment(fragmentHome()) }
        btnFragmentA.setOnClickListener { replaceFragment(beritaFragment()) } // Replace with your FragmentA class name
        btnFragmentB.setOnClickListener { replaceFragment(profilefragment()) } // Replace with your FragmentB class name
    }

    // Method to replace fragments in the container (R.id.main by default)
    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.main, fragment) // Replace the content of the container (adjust ID if needed)
        transaction.addToBackStack(null) // Add the transaction to back stack for navigation
        transaction.commit()
    }

    // You can add additional methods for other fragment transactions (e.g., add, remove)
    // following similar patterns.
}