package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoShowPendingToggle(modifier: Modifier = Modifier, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "미완료 항목만 보기",
            fontSize = 18.sp)
        Spacer(modifier = Modifier.width(10.dp))
        Switch(modifier = modifier, checked = isChecked, onCheckedChange = onCheckedChange)
    }
}