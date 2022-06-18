package com.ass

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.ass.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAlarmBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext, notification)

            ringtone.play()
        }

        binding.btn2.setOnClickListener {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager: VibratorManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE)
                        as VibratorManager

                vibratorManager.defaultVibrator
            } else {
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }

            // 앱 mixSdk를 API 26, 즉 VERSION_CODES.O로 지정해놔서 불필요한 분기문
            // 다만 공부를 위해 남겨둠
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(500,
                    VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                vibrator.vibrate(500)
            }
        }

        binding.btn3.setOnClickListener {
            alarmTest()
        }
    }

    private fun alarmTest() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder

        // 앱 mixSdk를 API 26, 즉 VERSION_CODES.O로 지정해놔서 불필요한 분기문
        // 다만 공부를 위해 남겨둠
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelID = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelID,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            // 채널에 다양한 정보 설정
            channel.description = "My Channel One Description"
            channel.setShowBadge(true)
            val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
            channel.setSound(uri, audioAttributes)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100, 200, 100, 200)

            // 채널을 NotifiactionManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용해 빌더 생성
            builder = NotificationCompat.Builder(this, channelID)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("Content Title")
        builder.setContentText("Content Message")

        // 알림 취소 막기
//        builder.setAutoCancel(false)
//        builder.setOngoing(true)

        // 알림 발생
        manager.notify(11, builder.build())

        // 알림 취소
//        manager.cancel(11)

    }
}