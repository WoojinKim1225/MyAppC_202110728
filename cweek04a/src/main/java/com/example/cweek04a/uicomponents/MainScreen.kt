package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.cweek04a.model.TodoItemFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import com.example.cweek04a.model.Item
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getCurrentTime(): String {
    val formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm")
    return LocalDateTime.now().format(formatter)
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val s_todoList = remember {TodoItemFactory.makeTodoList()}
    var s_showPending by remember { mutableStateOf(false) }
    Column(Modifier.padding(10.dp, 10.dp)) {
        TodoListTitle()
        Text(
            text = "202110728 김우진",
            fontSize = 18.sp)
        TodoShowPendingToggle(
            modifier = Modifier,
            isChecked = s_showPending) {
            s_showPending = it
        }
        TodoList(s_todoList, s_showPending, modifier = Modifier.weight(1f))
        TodoItemInput(s_todoList, modifier = Modifier) {
            s_todoList.add(Item(it, getCurrentTime()) )
        }

    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}