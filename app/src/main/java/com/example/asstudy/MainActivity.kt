package com.example.asstudy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asstudy.databinding.ActivityMainBinding
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnMessage.text = "안녕하세요"
        binding.btnMessage.setOnClickListener {
            val url = "http://118.41.31.14/forestpoint/test"
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()
            
            client.newCall(request).enqueue(object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    thread { 
                        val str = response.body()?.string() ?: ""
                        val res = Gson().fromJson<ForestPointResponse>(str, ForestPointResponse::class.java)
                        println(res.data[0])
                    }
                }
            })
        }
    }
}