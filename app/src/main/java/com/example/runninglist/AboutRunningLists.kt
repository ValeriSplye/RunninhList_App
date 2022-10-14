package com.example.runninglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runninglist.adapters.AbountScreanAdapter
import com.example.runninglist.databinding.ActivityAboutRunningListsBinding

class AboutRunningLists : AppCompatActivity() {
    lateinit var binding: ActivityAboutRunningListsBinding
    private val adapter = AbountScreanAdapter()
    private val TitleList = listOf("Функции","Польза системы","Ещё наши приложения","Идея")
    private val  TextList = listOf("Добавление и перенос дел","С этим приложением вести свои дела проще.Если какие-то дела назначенные за день не получилось выполнить,то их можно просто перенести!","Ещё наши приложения","Основная идея этой системы планирования заключается в том, что вся неделя- это непрерывно бегущий список дел, от сюда и название RUNNING LIST или же бегущий список")
    private val ImageList = listOf(R.drawable.abount1,R.drawable.about2,R.drawable.about3,R.drawable.abount1)
    private var index : Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutRunningListsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AddList()
    }
    private fun AddList(){

       binding.apply {
           revVi.layoutManager = LinearLayoutManager(this@AboutRunningLists)

           revVi.adapter = adapter
           for(i in 0..3){
               val item = AboutScrean(TitleList[index],TextList[index],ImageList[index])
               adapter.appLant(item)
               index++

           }
           backscreenselect.setOnClickListener{
               val intent = Intent(this@AboutRunningLists , ScreenSelection::class.java)
               startActivity(intent)
               finish()
           }

       }
    }
}