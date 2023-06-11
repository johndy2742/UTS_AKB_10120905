package com.example.uts_akb_10120905.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.uts_akb_10120905.MainActivity
import com.example.uts_akb_10120905.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val tlOnBoarding = findViewById<TabLayout>(R.id.tlOnBoarding)
        vpOnBoarding.apply {
            adapter = OnBoardingPagerAdapter(this@OnBoardingActivity)
            TabLayoutMediator(
                tlOnBoarding,
                this
            ) { tab, position ->
            }.attach()
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    initSetBtnNext()
                    initSetBtnPrevious()
                }
            })
        }

        initSetBtnNext()
        initSetBtnPrevious()
        initSetOnClick()

    }

    private fun initSetBtnNext() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.text =
            if (vpOnBoarding.currentItem == 2) resources.getString(R.string.explore)
            else resources.getString(R.string.txtcontinue)
    }

    private fun initSetBtnPrevious() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val btnPrevious = findViewById<ImageButton>(R.id.btnPrevious)
        btnPrevious.isVisible =
            vpOnBoarding.currentItem != 0
    }

    private fun initSetOnClick() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val btnPrevious = findViewById<ImageButton>(R.id.btnPrevious)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnPrevious.setOnClickListener {
            vpOnBoarding.setCurrentItem(
                vpOnBoarding.currentItem.minus(1),
                true)
            initSetBtnNext()
            initSetBtnPrevious()
        }

        btnNext.setOnClickListener {
            if (vpOnBoarding.currentItem == 2) {
                startActivity(Intent(this, MainActivity::class.java))
            } else vpOnBoarding.setCurrentItem(
                vpOnBoarding.currentItem.plus(1),
                true
            )
            initSetBtnNext()
            initSetBtnPrevious()
        }
    }

}