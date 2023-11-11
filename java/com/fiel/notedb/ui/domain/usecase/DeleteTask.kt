package com.fiel.notedb.ui.domain.usecase

import com.fiel.notedb.ui.data.ReposityImpl
import com.fiel.notedb.ui.domain.entity.Task
import javax.inject.Inject

class DeleteTask @Inject constructor(private val repository: ReposityImpl) {
    suspend operator fun invoke(task:Task)=repository.deleteTask(task)

}