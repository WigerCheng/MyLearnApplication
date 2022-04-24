package com.example.myapplication.animation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class AnimationListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_list)
        findViewById<Button>(R.id.btn_basic_animation).setOnClickListener {
            Intent(this, BasicAnimationActivity::class.java).also {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.btn_frame_animation).setOnClickListener {
            Intent(this, FrameAnimationActivity::class.java).also {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.btn_fade_animation).setOnClickListener {
            Intent(this, FadeAnimationActivity::class.java).also {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.btn_prop_animation).setOnClickListener {
            Intent(this, PropAnimationActivity::class.java).also {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.btn_circle_animation).setOnClickListener {
            Intent(this, CircleAnimationActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}