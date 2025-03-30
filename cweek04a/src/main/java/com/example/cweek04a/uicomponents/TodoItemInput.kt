package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.Item
import com.example.cweek04a.model.TodoItemFactory

@Composable
fun TodoItemInput(todoList: MutableList<Item>, modifier: Modifier = Modifier, onClick: (String) -> Unit) {
    var textFieldState by remember { mutableStateOf("") }
    Row( modifier = Modifier.fillMaxWidth()) {
        TextField(value = textFieldState,
            modifier = Modifier.weight(1f),
            onValueChange = {textFieldState = it},
            placeholder = {Text("할 일을 입력하세요")})
        Spacer(modifier = Modifier.width((10.dp)))
        Button(onClick = {
            onClick(textFieldState)
            textFieldState = ""
        }) {
            Text(text = "추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList()) {

    }
}