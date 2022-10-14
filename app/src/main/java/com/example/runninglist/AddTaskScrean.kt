package com.example.runninglist

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runninglist.adapters.DaysOfWeekAdapter
import com.example.runninglist.databinding.ActivityAddTaskScreanBinding
import java.text.SimpleDateFormat
import java.util.*

class AddTaskScrean : AppCompatActivity(), DaysOfWeekAdapter.Listener,AboutTaskAdapter.Listener {

    var tasks = listOf<AboutTask>()
    lateinit var binding: ActivityAddTaskScreanBinding
    private var Day: Int = -1
    private var CodifierDay: Int = 0 // день, что идёт в класс
    var Codifier: String = "" // кодификартор для фотографии
    private val DayWeekList =
        listOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье")

    private var index: Int = 0
    private var countButtonEveryday: Int = 0 // функциии флажка ButtonEveryTask
    private var NameTask: String = ""
    private var Daily = "Не ежедневная"  // Ежедневная или нет задача ?
    private var TaskStartDay: String = "" // день
    private var ImportanceOfTheTask: String = "" // уровень важности задачи
    private val adapter = DaysOfWeekAdapter(this)
    private var ImageId1: Int = 0
    private var ImageId2: Int = 0
    private var ImageId3: Int = 0
    private var ImageId4: Int = 0
    private var ImageId5: Int = 0
    private var ImageId6: Int = 0
    private var ImageId7: Int = 0
    private val adapter2 = AboutTaskAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddTaskScreanBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // функция флажка для ежедневной задачи
        binding.ButtonEveryTask.setOnClickListener { view: View ->
            if (countButtonEveryday == 0 || countButtonEveryday % 2 == 0) {
                binding.ButtonEveryTask.setImageResource(R.drawable.tickk)
                countButtonEveryday++
                Daily = "Ежедневная"

            } else {
                binding.ButtonEveryTask.setImageResource(R.drawable.checkno)
                countButtonEveryday++
                Daily = "Не ежедневная"
            }
        }
        // Флажок по уровням сложности
        binding.LvlLIte.setOnClickListener { view: View ->
            var toast = Toast.makeText(this, "Уровень сложности лёгкий", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
            ImportanceOfTheTask = "Лёгкий"
        }
        binding.imageView9.setOnClickListener { view: View ->
            var toast = Toast.makeText(this, "Уровень сложности средний", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
            ImportanceOfTheTask = "Средний"
        }
        binding.imageView10.setOnClickListener { view: View ->
            var toast = Toast.makeText(this, "Уровень сложности hard", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
            ImportanceOfTheTask = "Сложный"
        }

        binding.AddTaskButton.setOnClickListener { view: View ->
            var sdf = SimpleDateFormat("EEEE")
            var d = Date()
            var dayOfTheWeek = sdf.format(d)
            when(dayOfTheWeek.toString()) {
                "Monday" -> Day = 1
                "Tuesday" -> Day = 2
                "Wednesday" -> Day = 3
                "Thursday" -> Day = 4
                "Friday" -> Day = 5
                "Saturday" -> Day = 6
                "Sunday" -> Day = 7
            }

            if (Daily == "Ежедневная" || Daily == "Не ежедневная") {
                WhatPictureDefinition()
            }



            if (binding.editText.text.toString().isNotEmpty()) {

                NameTask = binding.editText.text.toString()

                if (Codifier.isNotEmpty() && CodifierDay != 0) {
                    val task = DataClassTaskUsers(
                        binding.editText.text.toString(),
                        ImageId1,
                        ImageId2,
                        ImageId3,
                        ImageId4,
                        ImageId5,
                        ImageId6,
                        ImageId7,
                        CodifierDay,
                        Codifier
                    )

                    var editIntent = Intent().apply {
                        putExtra("task", task)
                    }
                    setResult(RESULT_OK, editIntent)
                    finish()

                }
            }

        else {
            var toast =
                Toast.makeText(this, "Поле для названия не должно быть пустым ", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()

        }

    }
    AddList()

}
    // функция установления кодификатора для изображения
     private fun WhatPictureDefinition() {
        var imageictask = listOf(
            R.drawable.ic_iconramk,
            R.drawable.ic_icongreenlvl,
            R.drawable.ic_iconellovlvl,
            R.drawable.ic_iconredlvl
        )


        var CodifierAPictureComplectity = 0

        when (ImportanceOfTheTask) {
            "Лёгкий" -> CodifierAPictureComplectity = 1;
            "Средний" -> CodifierAPictureComplectity = 2;
            "Сложный" -> CodifierAPictureComplectity = 3;
        }
        when (TaskStartDay) {
            "Понедельник" -> CodifierDay = 1
            "Вторник" -> CodifierDay = 2
            "Среда" -> CodifierDay = 3
            "Четверг" -> CodifierDay = 4
            "Пятница" -> CodifierDay = 5
            "Суббота" -> CodifierDay = 6
            "Воскресенье" -> CodifierDay = 7
        }
        if (Daily == "Ежедневная") {
            if (CodifierAPictureComplectity == 1) {
                when (CodifierDay) {
                    1 -> {
                        ImageId1 = imageictask[1]
                        ImageId2 = imageictask[1]
                        ImageId3 = imageictask[1]
                        ImageId4 = imageictask[1]
                        ImageId5 = imageictask[1]
                        ImageId6 = imageictask[1]
                        ImageId7 = imageictask[1]
                    }
                    2 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[1]
                        ImageId3 = imageictask[1]
                        ImageId4 = imageictask[1]
                        ImageId5 = imageictask[1]
                        ImageId6 = imageictask[1]
                        ImageId7 = imageictask[1]
                    }
                    3 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[1]
                        ImageId4 = imageictask[1]
                        ImageId5 = imageictask[1]
                        ImageId6 = imageictask[1]
                        ImageId7 = imageictask[1]
                    }
                    4 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[1]
                        ImageId5 = imageictask[1]
                        ImageId6 = imageictask[1]
                        ImageId7 = imageictask[1]
                    }
                    5 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[1]
                        ImageId6 = imageictask[1]
                        ImageId7 = imageictask[1]
                    }
                    6 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[1]
                        ImageId7 = imageictask[1]
                    }
                    7 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[1]
                    }
                }
                Codifier = "D${CodifierAPictureComplectity}${CodifierDay}"
            } else if (CodifierAPictureComplectity == 2) {
                when (CodifierDay) {
                    1 -> {
                        ImageId1 = imageictask[2]
                        ImageId2 = imageictask[2]
                        ImageId3 = imageictask[2]
                        ImageId4 = imageictask[2]
                        ImageId5 = imageictask[2]
                        ImageId6 = imageictask[2]
                        ImageId7 = imageictask[2]
                    }
                    2 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[2]
                        ImageId3 = imageictask[2]
                        ImageId4 = imageictask[2]
                        ImageId5 = imageictask[2]
                        ImageId6 = imageictask[2]
                        ImageId7 = imageictask[2]
                    }
                    3 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[2]
                        ImageId4 = imageictask[2]
                        ImageId5 = imageictask[2]
                        ImageId6 = imageictask[2]
                        ImageId7 = imageictask[2]
                    }
                    4 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[2]
                        ImageId5 = imageictask[2]
                        ImageId6 = imageictask[2]
                        ImageId7 = imageictask[2]
                    }
                    5 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[2]
                        ImageId6 = imageictask[2]
                        ImageId7 = imageictask[2]
                    }
                    6 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[2]
                        ImageId7 = imageictask[2]
                    }
                    7 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[2]
                    }
                }
                Codifier = "D${CodifierAPictureComplectity}${CodifierDay}"
            } else if (CodifierAPictureComplectity == 3) {
                when (CodifierDay) {
                    1 -> {
                        ImageId1 = imageictask[3]
                        ImageId2 = imageictask[3]
                        ImageId3 = imageictask[3]
                        ImageId4 = imageictask[3]
                        ImageId5 = imageictask[3]
                        ImageId6 = imageictask[3]
                        ImageId7 = imageictask[3]
                    }
                    2 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[3]
                        ImageId3 = imageictask[3]
                        ImageId4 = imageictask[3]
                        ImageId5 = imageictask[3]
                        ImageId6 = imageictask[3]
                        ImageId7 = imageictask[3]
                    }
                    3 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[3]
                        ImageId4 = imageictask[3]
                        ImageId5 = imageictask[3]
                        ImageId6 = imageictask[3]
                        ImageId7 = imageictask[3]
                    }
                    4 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[3]
                        ImageId5 = imageictask[3]
                        ImageId6 = imageictask[3]
                        ImageId7 = imageictask[3]
                    }
                    5 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[3]
                        ImageId6 = imageictask[3]
                        ImageId7 = imageictask[3]
                    }
                    6 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[3]
                        ImageId7 = imageictask[3]
                    }
                    7 -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[3]
                    }


                }
                Codifier = "D${CodifierAPictureComplectity}${CodifierDay}"
            }
        }
            else if (Daily == "Не ежедневная") {
                if (CodifierAPictureComplectity != 0) {
                }
                Codifier = "${CodifierAPictureComplectity}${CodifierDay}"
                when (Codifier) {
                    "11" -> {
                        ImageId1 = imageictask[1]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "21" -> {
                        ImageId1 = imageictask[2]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "31" -> {
                        ImageId1 = imageictask[3]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "12" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[1]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }

                    "22" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[2]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "32" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[3]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "13" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[1]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "23" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[2]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "33" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[3]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "14" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[1]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "24" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[2]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "34" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[3]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "15" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[1]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "25" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[2]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "35" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[3]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[0]
                    }
                    "16" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[1]
                        ImageId7 = imageictask[0]
                    }
                    "26" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[2]
                        ImageId7 = imageictask[0]
                    }
                    "36" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[3]
                        ImageId7 = imageictask[0]
                    }
                    "17" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[1]
                    }
                    "27" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[2]
                    }
                    "37" -> {
                        ImageId1 = imageictask[0]
                        ImageId2 = imageictask[0]
                        ImageId3 = imageictask[0]
                        ImageId4 = imageictask[0]
                        ImageId5 = imageictask[0]
                        ImageId6 = imageictask[0]
                        ImageId7 = imageictask[3]
                    }


                }
            }

            Toast.makeText(this, "${Codifier}", Toast.LENGTH_SHORT).show()


    }
    // дни недели
    private fun AddList(){
        var sdf = SimpleDateFormat("EEEE")
        var d = Date()
        var dayOfTheWeek = sdf.format(d)
        when(dayOfTheWeek.toString()) {
            "Monday" -> Day = 1
            "Tuesday" -> Day = 2
            "Wednesday" -> Day = 3
            "Thursday" -> Day = 4
            "Friday" -> Day = 5
            "Saturday" -> Day = 6
            "Sunday" -> Day = 7
        }
        binding.apply {

            recyclerView.layoutManager = LinearLayoutManager(this@AddTaskScrean)

            recyclerView.adapter = adapter
           /* for (i in 0..6) {
                val item = DaysOfTheWeek(DayWeekList[index])
                adapter.appLant(item)
                index++

            }*/
                if(Day != 1) {
                    index = Day-1
                    for (i in Day-1..6) {
                        val item = DaysOfTheWeek(DayWeekList[index])
                        adapter.appLant(item)
                        index++

                    }

                }
                else {
                    for (i in 0..6) {
                        val item = DaysOfTheWeek(DayWeekList[index])
                        adapter.appLant(item)
                        index++

                    }
                }
        }
    }
    //обозначения выбора для пользователя
    override fun onClick1(day: DaysOfTheWeek){
        Toast.makeText(this,"Выбран день недели : ${day.DayWeek}",Toast.LENGTH_SHORT).show()
        TaskStartDay = day.DayWeek
    }





}