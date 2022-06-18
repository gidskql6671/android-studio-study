package com.ass

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ass.databinding.ActivityAlertDialogBinding
import com.ass.databinding.DialogInputBinding

class AlertDialogActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAlertDialogBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val items = arrayOf("사과", "복숭아", "수박", "딸기")
        binding.btnSetItems.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("setItems test")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(items
                ) { _, p1 -> Log.d("ass", "선택한 과일 : ${items[p1]}") }
                setPositiveButton("닫기", null)

                show()
            }
        }

        binding.btnSetMultiChoiceItems.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("setMultiChoiceItems test")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(items, booleanArrayOf(true, false, true, false)) {
                    _, p1, p2 -> Log.d("ass", "${items[p1]}이 ${if(p2) "선택되었습니다." else "선택 해제되었습니다."}")
                }
                setPositiveButton("닫기", null)

                show()
            }
        }

        binding.btnSetSingleChoiceItems.setOnClickListener {
            AlertDialog.Builder(this).run {
                setTitle("setSingleChoiceItems test")
                setIcon(android.R.drawable.ic_dialog_info)
                setSingleChoiceItems(items, 1) {
                        _, p1 -> Log.d("ass", "${items[p1]}이 선택되었습니다")
                }
                setPositiveButton("닫기", null)
                setCancelable(false)

                show()
            }.setCanceledOnTouchOutside(false)
        }

        binding.btnCustomDialog.setOnClickListener {
            val dialogBinding = DialogInputBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run {
                setTitle("Input")
                setView(dialogBinding.root)
                setPositiveButton("닫기", null)
                show()
            }
        }
    }
}