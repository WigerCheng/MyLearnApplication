package com.example.myapplication.view.imageview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        findViewById<Button>(R.id.btn_image_view_scale).setOnClickListener {
            Intent(this, ImageViewScaleActivity::class.java).also { startActivity(it) }
        }

        findViewById<Button>(R.id.btn_image_view_adjust).setOnClickListener {
            Intent(this, ImageViewScaleActivity1::class.java).also { startActivity(it) }
        }

    }


}