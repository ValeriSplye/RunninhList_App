package com.example.runninglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runninglist.adapters.CompletedUserTaskAdapters
import com.example.runninglist.databinding.ActivityCompletedScreenTaskBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CompletedScreenTask : AppCompatActivity() {
    private lateinit var binding: com.example.runninglist.databinding.ActivityCompletedScreenTaskBinding
    private var adapter = CompletedUserTaskAdapters()
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompletedScreenTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.taskcompletedlist.layoutManager = LinearLayoutManager(this@CompletedScreenTask)
        binding.taskcompletedlist.adapter = adapter
        binding.backscreenselect.setOnClickListener {
            val intent = Intent(this@CompletedScreenTask, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        GetUserTask()

    }
    private fun GetUserTask(){
        lifecycleScope.launch(Dispatchers.IO) {
            var tasks =  (applicationContext as App).repository.getAllCompletedTask()
            withContext(Dispatchers.Main) {
               adapter.setsTask(tasks)
            }
        }
    }
}