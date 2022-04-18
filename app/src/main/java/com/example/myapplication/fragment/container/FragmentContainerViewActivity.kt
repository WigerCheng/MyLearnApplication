package com.example.myapplication.fragment.container

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class FragmentContainerViewActivity : AppCompatActivity() {

    private lateinit var bFragment: BFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container_view)
        bFragment = BFragment.newInstance()
        findViewById<Button>(R.id.btn_change_fragment).setOnClickListener {
            supportFragmentManager.beginTransaction().also {
                it.add(R.id.fcv_container_view, bFragment)
                it.setReorderingAllowed(true)
                it.commit()
            }
        }
    }
}