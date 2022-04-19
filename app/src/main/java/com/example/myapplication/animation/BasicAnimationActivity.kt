package com.example.myapplication.animation

import android.os.Bundle
import android.view.View
import android.view.animation.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class BasicAnimationActivity : AppCompatActivity() {

    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_animation)

        view = findViewById(R.id.v_basic_animation)
        findViewById<Button>(R.id.btn_basic_animation_alpha).setOnClickListener {
            alphaAnimation(
                view
            )
        }
        findViewById<Button>(R.id.btn_basic_animation_rotate).setOnClickListener {
            rotateAnimation(
                view
            )
        }
        findViewById<Button>(R.id.btn_basic_animation_rotate_self).setOnClickListener {
            rotateSelfAnimation(
                view
            )
        }
        findViewById<Button>(R.id.btn_basic_animation_translate).setOnClickListener {
            translateAnimation(
                view
            )
        }
        findViewById<Button>(R.id.btn_basic_animation_scale).setOnClickListener {
            scaleAnimation(
                view
            )
        }
        findViewById<Button>(R.id.btn_basic_animation_scale_self).setOnClickListener {
            scaleSelfAnimation(
                view
            )
        }
        findViewById<Button>(R.id.btn_basic_animation_animation_set).setOnClickListener {
            animationSet(
                view
            )
        }
    }

    private fun alphaAnimation(v: View) {
        with(AlphaAnimation(0F, 1F)) {
            duration = 1000
            v.startAnimation(this)
        }
    }

    private fun rotateAnimation(v: View) {
        with(RotateAnimation(0F, 360F, 0F, 0F)) {
            duration = 1000
            v.startAnimation(this)
        }
    }

    private fun rotateSelfAnimation(v: View) {
        with(
            RotateAnimation(
                0F,
                360F,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5F,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5F
            )
        ) {
            duration = 1000
            v.startAnimation(this)
        }
    }

    private fun translateAnimation(v: View) {
        with(TranslateAnimation(0F, 200F, 0F, 300F)) {
            duration = 1000
            v.startAnimation(this)
        }
    }

    private fun scaleAnimation(v: View) {
        with(ScaleAnimation(0F, 2F, 0F, 2F)) {
            duration = 1000
            v.startAnimation(this)
        }
    }

    private fun scaleSelfAnimation(v: View) {
        with(
            ScaleAnimation(
                0F,
                1F,
                0F,
                1F,
                Animation.RELATIVE_TO_SELF,
                0.5F,
                Animation.RELATIVE_TO_SELF,
                0.5F
            )
        ) {
            duration = 1000
            v.startAnimation(this)
        }
    }

    private fun animationSet(v: View) {
        val animationSet = AnimationSet(true).apply { duration = 1000 }
        val alpha = AlphaAnimation(0F, 1F).apply { duration = 1000 }
        animationSet.addAnimation(alpha)
        val translate = TranslateAnimation(0F, 100F, 0F, 200F).apply { duration = 1000 }
        animationSet.addAnimation(translate)
        v.startAnimation(animationSet)
    }
}