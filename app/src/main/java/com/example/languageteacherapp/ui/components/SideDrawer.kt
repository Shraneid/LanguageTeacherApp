package com.example.languageteacherapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SideDrawer(onLanguageClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(onClick = { onLanguageClick("language 1") }) {
            Text("language 1")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { onLanguageClick("language 2") }) {
            Text("language 2")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { onLanguageClick("language 3") }) {
            Text("language 3")
        }
    }
}