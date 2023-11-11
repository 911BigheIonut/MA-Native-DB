package com.fiel.notedb.ui.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fiel.notedb.ui.domain.entity.Task
import com.fiel.notedb.ui.domain.repository.Repository

@Database(entities = [Task::class], exportSchema = false, version = 1)
abstract class TaskDatabase:RoomDatabase() {
    abstract fun taskDao():Repository

}
