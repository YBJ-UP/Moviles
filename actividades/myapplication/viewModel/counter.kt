package com.example.myapplication.viewModel

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class counter: ViewModel(){
    var _counter = mutableIntStateOf(0)
    val counter = _counter

    fun Add(){
        _counter.value++
    }

    fun Substract(){
        _counter.value--
    }
}

@Composable
fun Content(viewModel: counter){
    val State = viewModel.counter

    Button(onClick = { }) {
        Text("${State.value}")
    }

    Button(onClick = {viewModel.Add()}) {
        Text("+")
    }

    Button(onClick = {viewModel.Substract()}) {
        Text("-")
    }
}