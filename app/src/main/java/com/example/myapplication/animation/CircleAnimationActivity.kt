package com.example.myapplication.animation

import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class CircleAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_animation)
        findViewById<Button>(R.id.btn_circle_scale_down).setOnClickListener {
            val image = findViewById<ImageView>(R.id.img_circle)
            val width = image.width
            val height = image.height
            image.visibility = View.VISIBLE
            ViewAnimationUtils.createCircularReveal(
                image,
                width / 2,
                height / 2,
                0F,
                width.toFloat()
            ).apply {
                duration = 2000L
            }.also {
                it.start()
            }
        }
    }
}