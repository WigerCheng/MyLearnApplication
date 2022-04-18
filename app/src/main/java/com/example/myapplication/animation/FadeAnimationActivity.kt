package com.example.myapplication.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class FadeAnimationActivity : AppCompatActivity() {

    private var shortAnimationDuration: Int = 0

    private lateinit var loading: View
    private lateinit var content: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fade_animation)

        shortAnimationDuration = resources.getInteger(android.R.integer.config_longAnimTime)

        loading = findViewById(R.id.v_loading)
        content = findViewById(R.id.v_content)

        findViewById<Button>(R.id.btn_fade).also {
            it.setOnClickListener {
                crossFade()
            }
            it.setOnLongClickListener {
                content.visibility = View.GONE
                loading.visibility = View.VISIBLE
                loading.alpha = 1F
                true
            }
        }

    }

    private fun crossFade() {
        content.run {
            //淡入的View从初始状态的GONE切换成Visible，然后通过透明度0隐藏。
            visibility = View.VISIBLE
            alpha = 0F

            //执行动画
            animate()
                .alpha(1F)
                .setDuration(shortAnimationDuration.toLong())
        }
        loading.animate()
            .alpha(0F)
            .setDuration(shortAnimationDuration.toLong())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    loading.visibility = View.GONE
                }
            })
    }
}