//package com.fiel.notedb.ui.domain.repository
//
//interface Repository {
//}

package com.fiel.notedb.ui.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fiel.notedb.ui.domain.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface Repository {
    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM TaskDb ")
    fun getTasks(): Flow<List<Task>>

    @Query("SELECT * FROM TaskDb WHERE id = :id")
    suspend fun getByIdTask(id: Int): Task
}
