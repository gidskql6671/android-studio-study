package com.ass

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ass.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.navigateMessengerIntro.setOnClickListener {
            val intent = Intent(this, MessengerIntroActivity::class.java)
            startActivity(intent)
        }

        binding.navigateAlert.setOnClickListener {
            val intent = Intent(this, AlertDialogActivity::class.java)
            startActivity(intent)
        }

        binding.navigateStopwatch.setOnClickListener {
            val intent = Intent(this, StopwatchActivity::class.java)
            startActivity(intent)
        }

        binding.navigateAlarm.setOnClickListener {
            val intent = Intent(this, AlarmActivity::class.java)
            startActivity(intent)
        }
    }
}