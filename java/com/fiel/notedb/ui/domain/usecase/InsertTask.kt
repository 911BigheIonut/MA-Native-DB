package com.fiel.notedb.ui.domain.usecase

import com.fiel.notedb.ui.data.ReposityImpl
import com.fiel.notedb.ui.domain.entity.Task

class InsertTask constructor(private val reposity: ReposityImpl){
    suspend operator fun invoke(task:Task) = reposity.insertTask(task)
}