package com.fiel.notedb.ui.presentation.views.updateTask

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fiel.notedb.ui.domain.entity.Task
import com.fiel.notedb.ui.domain.usecase.TaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(
    private val useCase: TaskUseCase,
    private val savedStateHandle: SavedStateHandle
) :ViewModel(){
    var title by mutableStateOf("")
    var content by mutableStateOf("")
    var deadline by mutableStateOf("")
    var priority by mutableStateOf("")
    var category by mutableStateOf("")
    var recurrence by mutableStateOf("")

    val id = savedStateHandle.get<Int>(key="id")

    init{
        viewModelScope.launch {
            val task = id?.let {useCase.getByIdTask(it)}
            if(task!=null){
                content = task.content
                title = task.title
                deadline = task.deadline
                priority = task.priority
                category = task.category
                recurrence = task.recurrence
            }
        }
    }

    fun updateTask() = viewModelScope.launch {
        useCase.updateTask(Task(id!!, title=title, content=content, deadline = deadline, priority = priority, category = category, recurrence = recurrence))
    }


}