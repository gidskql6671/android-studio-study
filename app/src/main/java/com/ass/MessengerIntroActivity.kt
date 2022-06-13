package com.ass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ass.databinding.ActivityMessengerIntroBinding

class MessengerIntroActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMessengerIntroBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }
}