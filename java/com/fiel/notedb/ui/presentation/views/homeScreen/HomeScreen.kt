package com.fiel.notedb.ui.presentation.views.homeScreen

import android.widget.Space
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.fiel.notedb.ui.presentation.navigation.Screens
import kotlinx.coroutines.processNextEventInCurrentThread

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun Home(){
//    HomeScreen()
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel= hiltViewModel()){
    val tasks=viewModel.tasks.collectAsState(initial = emptyList())
    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = "TaskIT") })
        }, floatingActionButton = { FloatingActionButton(onClick = {navController.navigate(Screens.AddScreen.route)}) {
            Icon(imageVector = Icons.Default.Add, contentDescription ="" )
        }}
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(tasks.value){
                Box(
                    modifier = Modifier   ///amm schimbaatt aiciiii
                        .padding(16.dp)
                        .border(1.dp, color = Color.Gray)) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                            Text(text = "#${tasks.value.indexOf(it)+1}")
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(onClick = { navController.navigate(Screens.UpdateScreen.getById(it.id)) }) {
                                Icon(
                                    tint = Color.Blue.copy(0.5f),
                                    imageVector = Icons.Default.Edit, contentDescription = "")

                            }
                            IconButton(onClick = { viewModel.deleteTask(task=it) }) {
                                Icon(
                                    tint = Color.Red.copy(0.5f),
                                    imageVector = Icons.Default.Delete, contentDescription = "")

                            }
                        }
                        Text(text = it.title, fontWeight = FontWeight.Bold, fontSize = 24.sp) //trebe in domain sa imi fac entity-ul dar nu a aratat codul veci
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.content)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.deadline)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.priority)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.category)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = it.recurrence)
                    }
                }
            }


        }
    }
}