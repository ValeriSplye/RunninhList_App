package com.example.runninglist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.runninglist.AboutTask
import com.example.runninglist.CompletedTask

@Dao
interface UserTaskDao {
    @Insert
    suspend fun insert(task : AboutTask)
    @Query("SELECT * FROM ${AboutTask.Table_NAME} WHERE ${AboutTask._Description} NOT LIKE 'Del' ") // изменить
    suspend fun getAllTask() : List<AboutTask>
    @Update
    suspend fun update(task: AboutTask)
    @Query("SELECT * FROM ${AboutTask.Table_NAME} WHERE ${AboutTask._Description} LIKE 'Del' ") // изменить
    suspend fun getAllCompletedTask() : List<AboutTask>
    @Delete
    suspend fun delete(task: AboutTask)
    @Query("DELETE FROM ${AboutTask.Table_NAME} WHERE ${AboutTask._Description} LIKE 'Del' ") // изменить
    suspend fun DeleteTask()
}