package com.lanier.bili.modules.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lanier.bili.R
import com.lanier.bili.modules.main.fragment.HomeFra
import com.lanier.bili.modules.main.fragment.MineFra
import com.lanier.bili.utils.FragmentHelper

class MainAct : AppCompatActivity() {

    private val vm by viewModels<MainVM>()
    private val fragments = mutableListOf<FragmentHelper.SwitchFragment>()

    private lateinit var fragmentHelper: FragmentHelper

    private val btmNavigator by lazy {
        findViewById<BottomNavigationView>(R.id.btmView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        fragments.add(
            FragmentHelper.SwitchFragment(
                fragment = HomeFra.newInstance()
            )
        )
        fragments.add(
            FragmentHelper.SwitchFragment(
                fragment = MineFra.newInstance()
            )
        )

        fragmentHelper = FragmentHelper(R.id.frameLayout, fragmentManager = supportFragmentManager)

        fragmentHelper.setFragments(fragments)
        fragmentHelper.switchFra(0)

        btmNavigator.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_id_home -> fragmentHelper.switchFra(0)
                R.id.menu_id_mine -> fragmentHelper.switchFra(1)
            }
            true
        }
    }
}