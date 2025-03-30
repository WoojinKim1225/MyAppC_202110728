package com.example.cweek04a.uicomponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cweek04a.R

@Composable
fun TodoListTitle(modifier: Modifier = Modifier) {
    Text(text = stringResource(R.string.todoListTitle),
        modifier = Modifier,
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview
@Composable
private fun TodoListTitlePreview() {
    TodoListTitle()
}