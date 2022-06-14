package com.ass

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ass.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAlertDialogBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val items = arrayOf("사과", "복숭아", "수박", "딸기")
        binding.btnSetItems.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("items test")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(items
                ) { _, p1 -> Log.d("ass", "선택한 과일 : ${items[p1]}") }
                setPositiveButton("닫기", null)

                show()
            }
        }
    }
}