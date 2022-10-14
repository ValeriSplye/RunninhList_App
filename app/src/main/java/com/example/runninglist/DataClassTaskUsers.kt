package com.example.runninglist

import androidx.room.ColumnInfo
import java.io.Serializable

data class DataClassTaskUsers(var NameTask: String, var ImageTask1: Int, var ImageTask2: Int, var ImageTask3: Int, var ImageTask4: Int, var ImageTask5: Int, var ImageTask6: Int, var ImageTask7: Int, var Day:Int, var Description: String):Serializable{}
