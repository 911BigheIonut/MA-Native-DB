package com.fiel.notedb.ui.presentation.views.addTask

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.fiel.notedb.ui.presentation.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavHostController, viewModel: AddViewModel= hiltViewModel()) {
    Scaffold ( topBar = {
        TopAppBar(
            navigationIcon={
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            },
            title = { Text(text = "New Task") })
    }){
        Column(modifier = Modifier
            .padding(it)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = {Text(text = "title")},
            value = viewModel.title ,
            onValueChange ={
                viewModel.title = it
            } )
        Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "content")},
                value = viewModel.content ,
                onValueChange ={
                viewModel.content = it
                } )
            Spacer(modifier = Modifier.height(16.dp)) //aici am adaugat mai jos
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "deadline")},
                value = viewModel.deadline ,
                onValueChange ={
                    viewModel.deadline = it
                } )
            Spacer(modifier = Modifier.height(16.dp))
            //pana aici am adaugat chestii noi

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "priority")},
                value = viewModel.priority ,
                onValueChange ={
                    viewModel.priority = it
                } )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "category")},
                value = viewModel.category ,
                onValueChange ={
                    viewModel.category = it
                } )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "recurrence")},
                value = viewModel.recurrence ,
                onValueChange ={
                    viewModel.recurrence = it
                } )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.addTask()
                    navController.popBackStack()
                }) {
                Text(text = "Add task")
            }
        }
    }
}