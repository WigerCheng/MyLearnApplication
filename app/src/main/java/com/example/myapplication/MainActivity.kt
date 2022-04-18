package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.animation.AnimationListActivity
import com.example.myapplication.fragment.FragmentListActivity
import com.example.myapplication.view.imageview.ImageViewActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.btn_animation).setOnClickListener {
            Intent(this, AnimationListActivity::class.java).also {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.btn_fragment).setOnClickListener {
            Intent(this, FragmentListActivity::class.java).also {
                startActivity(it)
            }
        }
        findViewById<Button>(R.id.btn_image_view).setOnClickListener {
            Intent(this, ImageViewActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}