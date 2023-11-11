package com.fiel.notedb.ui.data

import com.fiel.notedb.ui.domain.entity.Task
import com.fiel.notedb.ui.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReposityImpl @Inject constructor (private val dao:Repository):Repository{

    override suspend fun  insertTask(task:Task) = dao.insertTask(task = task)

    override suspend fun  updateTask(task:Task) = dao.updateTask(task = task)

    override suspend fun  deleteTask(task:Task) = dao.deleteTask(task = task)

    override fun getTasks():Flow<List<Task>> = dao.getTasks()

    override suspend fun getByIdTask(id:Int) : Task = dao.getByIdTask(id)


}