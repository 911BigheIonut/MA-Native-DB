package com.fiel.notedb.ui.presentation.views.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiel.notedb.ui.domain.entity.Task
import com.fiel.notedb.ui.domain.usecase.TaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: TaskUseCase):ViewModel() {
    val tasks = useCase.getTasks()

    fun deleteTask(task:Task)=viewModelScope.launch {
        useCase.deleteTask(task)
    }
}