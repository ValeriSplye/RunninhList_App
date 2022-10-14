package com.example.runninglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runninglist.AboutTask
import com.example.runninglist.CompletedTask
import com.example.runninglist.R

class CompletedUserTaskAdapters: RecyclerView.Adapter<CompletedUserTaskAdapters.TaskHolder2>() {
    val taskCompletedList = ArrayList<CompletedTask>()
    class TaskHolder2(item : View) : RecyclerView.ViewHolder(item) {

        val binding = com.example.runninglist.databinding.TaskitemBinding.bind(item)
        fun bind(taskcompleted : CompletedTask) = with(binding){
            compledettaskName.text = taskcompleted.NameTaskCompledet

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder2 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.taskitem,parent,false)
        return TaskHolder2(view)
    }

    override fun onBindViewHolder(holder: TaskHolder2, position: Int) {
        holder.bind(taskCompletedList[position])
    }

    fun setsTask(taskList :List<AboutTask>) {
         taskCompletedList.clear()
         val newlist = mutableListOf<CompletedTask>()
        taskList.forEach {
                newlist +=CompletedTask(it.NameTask)
        }
        taskCompletedList.addAll(newlist)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return  taskCompletedList.size
    }
    fun AddCompletedTask(task : CompletedTask){
        taskCompletedList.add(task)
        notifyDataSetChanged()
    }


}