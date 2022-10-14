package com.example.runninglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.runninglist.databinding.ActivityScreenSelectionBinding

class ScreenSelection : AppCompatActivity() {
    lateinit var binding : ActivityScreenSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.NavigateToAboutScrean.setOnClickListener { view: View ->
            val intent = Intent(this@ScreenSelection, AboutRunningLists::class.java)
            startActivity(intent)
            finish()
        }
        binding.NavigateToTask.setOnClickListener{view:View ->

            val intent = Intent(this@ScreenSelection, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

    }
}