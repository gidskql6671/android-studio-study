package com.example.asstudy

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Region
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.example.asstudy.databinding.ActivityMainBinding
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
//        testAPI()
        
        testColor()
    }

    fun getBitmapRegion(bitmap: Bitmap): Region? {
        var pixels: IntArray? = null
        var rgn: Region? = null
        var bMask = false
        val height = bitmap.height
        val width = bitmap.width
        try {
            pixels = IntArray(width * height)
            bitmap.getPixels(pixels, 0, width, 0, 0, width, height)
            rgn = Region(0, 0, 0, 0)
            var start = 0
            var end = 0
            for (j in height - 1 downTo 0) {
                for (i in 0 until width) {
                    if (pixels[i + width * j] != 0x00000000) {
                        if (!bMask) {
                            start = i
                            end = i + 1
                            bMask = true
                        } else {
                            end = i
                        }
                    } else {
                        if (bMask) {
                            rgn.op(Region(start, j, end, j + 1), Region.Op.XOR)
                        }
                        bMask = false
                    }
                }
                if (bMask) {
                    rgn.op(Region(start, j, end, j + 1), Region.Op.XOR)
                }
                bMask = false
            }
        } catch (e: IllegalArgumentException) {
        } catch (e: ArrayIndexOutOfBoundsException) {
        }
        pixels = null
        return rgn
    }
    
    @SuppressLint("ClickableViewAccessibility")
    private fun testColor() {
        val mRgn = getBitmapRegion(binding.imageButton.drawable.toBitmap())
        var i = 0
        binding.imageButton.setOnTouchListener {_, event -> 
            val x = event.x.toInt()
            val y = event.y.toInt()

            if (mRgn?.contains(x, y) == true) {
                println("터치 됨$i")
                i++
                true
            } else {
                false
            }
        }
    }

    private fun testAPI() {
        binding.btnMessage.text = "안녕하세요"
        binding.btnMessage.setOnClickListener {
            val url = "http://118.41.31.14/forestpoint/test"
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    thread {
                        val str = response.body()?.string() ?: ""
                        val res = Gson().fromJson<ForestPointResponse>(
                            str,
                            ForestPointResponse::class.java
                        )
                        println(res.data[0])
                    }
                }
            })
        }
    }
}