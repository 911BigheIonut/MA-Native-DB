package com.fiel.notedb.ui.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TaskDb")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title:String,
    val content:String,
    val deadline:String,
    val priority:String,
    val category:String,
    val recurrence:String
)