package com.fiel.notedb.ui.domain.usecase

data class TaskUseCase (
    val getTasks: GetTasks,
    val insertTask: InsertTask,
    val deleteTask: DeleteTask,
    val updateTask: UpdateTask,
    val getByIdTask: GetByIdTask
)