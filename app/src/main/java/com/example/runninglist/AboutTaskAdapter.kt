package com.example.runninglist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runninglist.databinding.TasklistLayuotBinding

// Вот адаптер главный для задач
class AboutTaskAdapter(val listener: Listener) : RecyclerView.Adapter<AboutTaskAdapter.HolderTask>(){
    var tasks = arrayListOf<AboutTask>()
    class HolderTask(item : View) : RecyclerView.ViewHolder(item){
       val binding =TasklistLayuotBinding.bind(item)
        fun bind(abouttask : AboutTask,listener: Listener) = with(binding){
            binding.ImageTask1.setImageResource(abouttask.ImageTask1)// Изображение на понедельник
            binding.ImageTask2.setImageResource(abouttask.ImageTask2)// Изображение на вторник
            binding.ImageTask3.setImageResource(abouttask.ImageTask3)// Изображение на среду
            binding.ImageTask4.setImageResource(abouttask.ImageTask4)// Изображение на четверг
            binding.ImageTask5.setImageResource(abouttask.ImageTask5)// Изображение на пятницу
            binding.ImageTask6.setImageResource(abouttask.ImageTask6)// Изображение на понедельник
            binding.ImageTask7.setImageResource(abouttask.ImageTask7)// Изображение на понедельник
            binding.TaskTitle.text = abouttask.NameTask
            itemView.setOnClickListener {
                listener.onClick(abouttask)

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutTaskAdapter.HolderTask {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tasklist_layuot,parent,false)
        return HolderTask(view)
    }

    override fun onBindViewHolder(holder: HolderTask, position: Int) {
       holder.bind(tasks[position],listener)
    }

    override fun getItemCount(): Int {
       return tasks.size
    }
    fun setsTask(taskList :List<AboutTask>){
        tasks.clear()
        tasks.addAll(taskList)
        notifyDataSetChanged()
    }
    fun appLant(task: AboutTask){
            tasks.add(task)
            notifyDataSetChanged()
    }
    fun removeItem(position: Int){
        tasks.removeAt(position)
        notifyDataSetChanged()
    }
    fun Sets() {
        val set: Set<AboutTask> = HashSet(tasks)
        tasks.clear()
        tasks.addAll(set)
        notifyDataSetChanged()
    }

    fun appLant2(){
        notifyDataSetChanged()
    }

   interface Listener{
       fun onClick(task: AboutTask){}
      fun Move(task: AboutTask){}

   }

}


