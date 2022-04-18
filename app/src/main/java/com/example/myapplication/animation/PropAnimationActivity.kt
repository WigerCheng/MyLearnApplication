package com.example.myapplication.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class PropAnimationActivity : AppCompatActivity() {

    private lateinit var blackView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prop_animation)
        blackView = findViewById(R.id.v_black_prop)
//        ValueAnimator.ofFloat(0f, 25f, 100f, 300f).apply {
//            duration = 1000
//            addUpdateListener {
//                blackView.translationX = it.animatedValue as Float
//            }
//            addListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator?) {
//                    ObjectAnimator.ofFloat(blackView, "translationY", 0f, 25f, 100f, 500f).apply {
//                        duration = 800
//                        interpolator = OvershootInterpolator()
//                        start()
//                    }
//                }
//            })
//            start()
//        }
        val animation1 = ObjectAnimator.ofFloat(blackView, "translationX", 0f, 100f, 250f).apply {
            Log.i("ani", "1")
            duration = 2500
            start()
        }
        val animation2 = ObjectAnimator.ofFloat(blackView, "translationY", 0f, 100f, 250f).apply {
            Log.i("ani", "2")
            duration = 3000
            interpolator = OvershootInterpolator()
            start()
        }
        val animation3 = ObjectAnimator.ofFloat(blackView, "translationX", 250f, 100f, 0f).apply {
            Log.i("ani", "3")
            duration = 2500
            start()
        }
        val animation4 = ObjectAnimator.ofFloat(blackView, "translationY", 250f, 100f, 0f).apply {
            Log.i("ani", "4")
            duration = 3000
            interpolator = OvershootInterpolator()
            start()
        }

        AnimatorSet().apply {
            play(animation1).before(animation2)
            play(animation2).after(animation1)
            play(animation3).after(animation2)
            play(animation4).after(animation3)
            start()
        }

    }
}