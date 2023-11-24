package com.gmb.webviewteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gmb.webviewteste.databinding.ActivityMainBinding
import com.gmb.webviewteste.fragments.HomeFragment
import com.gmb.webviewteste.fragments.VideoFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val videoFragment = VideoFragment()

        makeFragment(homeFragment)

        val listener = NavigationBarView.OnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeFragment(homeFragment)
                R.id.ic_video -> makeFragment(videoFragment)
            }
            true
        }
        binding.bottomNavigation.setOnItemSelectedListener(listener)
        binding.bottomNavigation.selectedItemId = R.id.ic_home
    }
    private fun makeFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}