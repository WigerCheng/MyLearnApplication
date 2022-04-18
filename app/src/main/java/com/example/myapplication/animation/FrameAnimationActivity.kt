package com.example.myapplication.animation

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.switchmaterial.SwitchMaterial

class FrameAnimationActivity : AppCompatActivity() {

    private lateinit var frameAnimation: AnimationDrawable
    private lateinit var tvOneShot: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_animation)
        tvOneShot = findViewById(R.id.tv_one_shot)

        findViewById<ImageView>(R.id.img_frame).apply {
            setBackgroundResource(R.drawable.frame_anim)
            frameAnimation = background as AnimationDrawable
            tvOneShot.text = "OneShot:${frameAnimation.isOneShot}"
        }

        findViewById<Button>(R.id.btn_start).setOnClickListener {
            frameAnimation.start()
        }

        findViewById<Button>(R.id.btn_stop).setOnClickListener {
            frameAnimation.stop()
        }

        findViewById<SwitchMaterial>(R.id.sw_one_shot).apply {
            isChecked = frameAnimation.isOneShot
        }.setOnCheckedChangeListener { _, isChecked ->
            if (frameAnimation.isRunning) {
                frameAnimation.stop()
            }
            frameAnimation.isOneShot = isChecked
            tvOneShot.text = "OneShot:${frameAnimation.isOneShot}"
            frameAnimation.start()
        }
    }
}