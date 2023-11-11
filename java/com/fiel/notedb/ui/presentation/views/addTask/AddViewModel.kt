package com.fiel.notedb.ui.presentation.views.addTask

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiel.notedb.ui.domain.entity.Task
import com.fiel.notedb.ui.domain.usecase.TaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val useCase: TaskUseCase):ViewModel() {
    var title by mutableStateOf("")
    var content by mutableStateOf("")
    var deadline by mutableStateOf("")
    var priority by mutableStateOf("")
    var category by mutableStateOf("")
    var recurrence by mutableStateOf("")

    fun addTask()=viewModelScope.launch{
        useCase.insertTask(Task(title = title, content = content, deadline = deadline, priority = priority, category = category, recurrence = recurrence))

    }
}