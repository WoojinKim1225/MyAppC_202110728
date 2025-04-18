package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cweek04a.model.Item
import com.example.cweek04a.model.TodoStatus

@Composable
fun ToDoItem(item: Item, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(4.dp)) {
        Text(
            text = item.content,
            fontSize = 16.sp,
            style = if(item.status == TodoStatus.COMPLETED)
                TextStyle(textDecoration = TextDecoration.LineThrough)
            else TextStyle(textDecoration = TextDecoration.None)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.time,
            fontSize = 10.sp)
    }
}

@Preview
@Composable
private fun ToDoItemPreview() {
    Column {
        ToDoItem(Item("모프 공부하기1", "03-25 14:00", TodoStatus.PENDING))
        Spacer(modifier = Modifier.height(4.dp))
        ToDoItem(Item("모프 공부하기2", "03-25 15:00", TodoStatus.COMPLETED))
    }
}