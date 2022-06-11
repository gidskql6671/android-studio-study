package com.ass

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.ass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nonData1 = User("t1", 10)
        val nonData2 = User("t1", 10)

        val data1 = DataClass("t2", 10)
        val data2 = DataClass("t2", 10)

        println("non data class equals : ${nonData1.equals(nonData2)}")
        println("data class equals : ${data1.equals(data2)}")

        println("non data class == : ${nonData1 == nonData2}")
        println("data class == : ${data1 == data2}")

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
}