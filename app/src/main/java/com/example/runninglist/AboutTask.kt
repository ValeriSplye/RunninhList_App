package com.example.runninglist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName ="UserTask")

data class AboutTask(
    @PrimaryKey()
    val id: Int,
    @ColumnInfo(name = Name_Task)
    var NameTask: String,
    @ColumnInfo(name = ImageMonday)
    var ImageTask1: Int,
    @ColumnInfo(name = ImageTuesday)
    var ImageTask2: Int,
    @ColumnInfo(name = ImageWednesday)
    var ImageTask3: Int,
    @ColumnInfo(name = ImageThursday)
    var ImageTask4: Int,
    @ColumnInfo(name = ImageFriday)
    var ImageTask5: Int,
    @ColumnInfo(name = ImageSaturday)
    var ImageTask6: Int,
    @ColumnInfo(name = ImageSunday)
    var ImageTask7: Int,
    @ColumnInfo(name = Day_Start)
    var Day:Int,
    @ColumnInfo(name = _Description)
    var Description: String)
    : Serializable
{


    public fun Set(Image1 : Int,Image2 :Int, Image3 :Int,Image4 :Int,Image5 :Int,Image6 :Int,Image7 :Int, Day1 :Int, Description2 : String){
         ImageTask1 = Image1
         ImageTask2 = Image2
         ImageTask3 = Image3
         ImageTask4 = Image4
         ImageTask5 = Image5
         ImageTask6 = Image6
         ImageTask7 = Image7
         Day = Day1
         Description = Description2
     }
    companion object{
        const val  Table_NAME ="UserTask"
        const val  ID ="id"
        const val Name_Task ="Name"
        const val  ImageMonday ="Monday"
        const val  ImageTuesday ="Tuesday"
        const val  ImageWednesday ="Wednesday"
        const val ImageThursday ="Thursday"
        const val  ImageFriday ="Friday"
        const val  ImageSaturday ="Saturday"
        const val ImageSunday ="Sunday"
        const val  Day_Start = "StartDay"
        const val  _Description ="Codificator"
    }
}

