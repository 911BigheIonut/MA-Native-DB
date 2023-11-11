package com.fiel.notedb.ui.di

import android.content.Context
import androidx.room.Room
import com.fiel.notedb.ui.data.ReposityImpl
import com.fiel.notedb.ui.data.TaskDatabase
import com.fiel.notedb.ui.domain.usecase.DeleteTask
import com.fiel.notedb.ui.domain.usecase.GetByIdTask
import com.fiel.notedb.ui.domain.usecase.GetTasks
import com.fiel.notedb.ui.domain.usecase.InsertTask
import com.fiel.notedb.ui.domain.usecase.TaskUseCase
import com.fiel.notedb.ui.domain.usecase.UpdateTask
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TaskModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context):TaskDatabase= Room.databaseBuilder(
        context=context,
        klass = TaskDatabase::class.java,
        name = "TaskDb"
    ).build()

    @Provides
    fun provideDao(dao:TaskDatabase)=dao.taskDao()

    @Provides
    fun provideTaskUseCase(repository:ReposityImpl) = TaskUseCase(
        getTasks = GetTasks(repository),
        getByIdTask = GetByIdTask(repository),
        deleteTask = DeleteTask(repository),
        updateTask = UpdateTask(repository),
        insertTask = InsertTask(repository)
    )
}