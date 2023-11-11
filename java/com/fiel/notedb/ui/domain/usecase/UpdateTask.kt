package com.fiel.notedb.ui.domain.usecase

import com.fiel.notedb.ui.data.ReposityImpl
import com.fiel.notedb.ui.domain.entity.Task
import javax.inject.Inject

class UpdateTask @Inject constructor(private val reposityImpl: ReposityImpl){
    suspend operator fun invoke(task:Task) = reposityImpl.updateTask(task)
}