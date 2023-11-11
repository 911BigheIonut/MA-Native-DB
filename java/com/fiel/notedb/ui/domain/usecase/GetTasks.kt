package com.fiel.notedb.ui.domain.usecase

import com.fiel.notedb.ui.data.ReposityImpl
import javax.inject.Inject

class GetTasks @Inject constructor(private val reposity: ReposityImpl){
    operator fun invoke() =reposity.getTasks()
}