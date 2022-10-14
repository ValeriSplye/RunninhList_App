package com.example.runninglist.Retrofits

data class UserTaskItem(
    val changed: Boolean,
    val completed: Boolean,
    val day: Int,
    val description: String,
    val difficulty: Int,
    val id: Int,
    val title: String,
    val user: Any,
    val week: Int
)