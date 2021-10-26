package com.softradix.templis.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.softradix.templis.R
import com.softradix.templis.utils.Constants.SPLASH_DELAY
import com.softradix.templis.utils.startActivity
import java.util.*

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_splash)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity<DashboardActivity>()
                finish()
            }

        }, SPLASH_DELAY)
    }
}