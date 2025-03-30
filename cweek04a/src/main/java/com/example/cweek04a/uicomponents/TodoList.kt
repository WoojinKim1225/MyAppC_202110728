package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.Item
import com.example.cweek04a.model.TodoItemFactory
import com.example.cweek04a.model.TodoStatus

@Composable
fun TodoList(todoList: MutableList<Item>, showPending: Boolean = false, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
            .verticalScroll(scrollState)
    ) {
        todoList.forEachIndexed { index, item ->
            if (!showPending || item.status == TodoStatus.PENDING) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        var checked by remember { mutableStateOf(item.status == TodoStatus.COMPLETED) }
                        TodoCheckBox(checked) {
                            checked = !checked
                            todoList[index] = item.copy(status = if (checked) TodoStatus.COMPLETED else TodoStatus.PENDING)
                        }
                        ToDoItem(item)
                    }
                }
                if (todoList.count() != index + 1) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
fun TodoCheckBox(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        checked = checked,
        onCheckedChange = { onCheckedChange(it) }
    )
}

@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList())
}
