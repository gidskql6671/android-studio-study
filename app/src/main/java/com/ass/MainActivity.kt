package com.ass

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val groupId = 0
        menu?.add(groupId, 0, 0, "menu1")
        menu?.add(groupId, 1, 0, "menu2")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        0 -> {
            Log.d("ass", "menu1 click")
            true
        }
        1 -> {
            Log.d("ass", "menu2 click")
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}