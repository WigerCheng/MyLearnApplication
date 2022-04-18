package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.fragment.container.FragmentContainerViewActivity

class FragmentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_list)
        findViewById<Button>(R.id.btn_fragment_container_view).setOnClickListener {
            Intent(this, FragmentContainerViewActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}