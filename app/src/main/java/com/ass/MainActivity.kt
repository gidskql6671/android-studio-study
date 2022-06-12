package com.ass

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.ass.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_BACK -> Log.d("ass", "뒤로가기 버튼")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("ass", "볼륨 업 버튼")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("ass", "볼륨 다운 버튼")
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        Log.d("ass", "뒤로가기 버튼")
        super.onBackPressed()
    }
}