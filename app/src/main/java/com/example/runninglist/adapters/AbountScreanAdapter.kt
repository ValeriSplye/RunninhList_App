package com.example.runninglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runninglist.AboutScrean
import com.example.runninglist.R
import com.example.runninglist.databinding.AboudItemBinding

class AbountScreanAdapter :RecyclerView.Adapter<AbountScreanAdapter.AboutAdapter>(){
    val AboudList = ArrayList<AboutScrean>()
    class AboutAdapter(item: View) :RecyclerView.ViewHolder(item) {

        val binding = AboudItemBinding.bind(item)
        fun bind(about : AboutScrean) = with(binding) {
            binding.tv1.text = about.Title
            binding.tv2.text =about.Text
            binding.imageIm.setImageResource(about.Image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aboud_item,parent,false)
        return AboutAdapter(view)
    }

    override fun onBindViewHolder(holder: AboutAdapter, position: Int) {
       holder.bind(AboudList[position])
    }

    override fun getItemCount(): Int {
       return AboudList.size
    }
    fun appLant(aboud : AboutScrean){
        AboudList.add(aboud)
        notifyDataSetChanged()
    }
}