package com.example.myapplication.view.imageview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ImageViewScaleActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view_scale1)

        val image = findViewById<ImageView>(R.id.img_scale)
        val spinnerScale = findViewById<Spinner>(R.id.spn_scale)
        val spinnerSize = findViewById<Spinner>(R.id.spn_scale_size)
        ArrayAdapter.createFromResource(
            this,
            R.array.image_scale_size,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSize.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.image_scale_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerScale.adapter = adapter
        }
        spinnerSize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val imageResource = when (position) {
                    0 -> R.drawable.short_equal
                    1 -> R.drawable.long_equal
                    2 -> R.drawable.long_height
                    3 -> R.drawable.long_width
                    4 -> R.drawable.short_height
                    5 -> R.drawable.short_width
                    else -> R.drawable.short_equal
                }
                image.setImageResource(imageResource)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                image.setImageResource(R.drawable.short_equal)
            }

        }
        spinnerScale.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                image.scaleType = when (position) {
                    0 -> ImageView.ScaleType.CENTER
                    1 -> ImageView.ScaleType.CENTER_CROP
                    2 -> ImageView.ScaleType.CENTER_INSIDE
                    3 -> ImageView.ScaleType.FIT_CENTER
                    4 -> ImageView.ScaleType.FIT_END
                    5 -> ImageView.ScaleType.FIT_START
                    6 -> ImageView.ScaleType.FIT_XY
                    7 -> ImageView.ScaleType.MATRIX
                    else -> ImageView.ScaleType.CENTER_INSIDE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                image.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }
        }
    }
}