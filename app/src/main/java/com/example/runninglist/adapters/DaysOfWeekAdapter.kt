package com.example.runninglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runninglist.DaysOfTheWeek
import com.example.runninglist.R
import com.example.runninglist.databinding.DaysWeekBinding

class DaysOfWeekAdapter(val listener: Listener) :RecyclerView.Adapter<DaysOfWeekAdapter.DaysWeek>(){
    val daylist = arrayListOf<DaysOfTheWeek>()
    class DaysWeek (item : View) :RecyclerView.ViewHolder(item){
        val binding = DaysWeekBinding.bind(item)
        fun bind(day : DaysOfTheWeek, listener: Listener) = with(binding) {
           binding.nameday.text =day.DayWeek
           itemView.setOnClickListener{
               listener.onClick1(day)
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysWeek {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.days_week,parent,false)
        return DaysWeek(view)
    }

    override fun onBindViewHolder(holder: DaysWeek, position: Int) {
       holder.bind(daylist[position],listener)
    }

    override fun getItemCount(): Int {
        return daylist.size
    }

    fun appLant(day: DaysOfTheWeek){
        daylist.add(day)
        notifyDataSetChanged()
    }

    interface  Listener{
      fun onClick1(day : DaysOfTheWeek)
    }
}