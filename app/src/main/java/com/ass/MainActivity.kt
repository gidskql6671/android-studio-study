package com.ass

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.ass.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var pauseTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()

            binding.btnStop.isEnabled = true
            binding.btnReset.isEnabled = true
            it.isEnabled = false
        }

        binding.btnStop.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.btnStart.isEnabled = true
            binding.btnReset.isEnabled = true
            it.isEnabled = false
        }

        binding.btnReset.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()

            binding.btnStart.isEnabled = true
            binding.btnStop.isEnabled = false
            it.isEnabled = false
        }

        binding.btnGotoMessengerIntro.setOnClickListener {
            val intent = Intent(this, MessengerIntroActivity::class.java)
            startActivity(intent)
        }
    }
}