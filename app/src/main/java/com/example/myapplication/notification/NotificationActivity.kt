package com.example.myapplication.notification

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class NotificationActivity : AppCompatActivity() {

    companion object {
        private const val NOTIFICATION_ACTION = "notification_action"
        private const val NOTIFICATION_REQUEST_CODE = 709394
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            action = NOTIFICATION_ACTION
        }
        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            NOTIFICATION_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
    }
}