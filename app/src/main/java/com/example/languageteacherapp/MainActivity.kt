package com.example.languageteacherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.languageteacherapp.data.model.Message
import com.example.languageteacherapp.ui.components.MessageCard
import com.example.languageteacherapp.ui.theme.LanguageTeacherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LanguageTeacherAppTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    MessageCard(Message("Android", "woohoo compose"))
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val drawerState = remember { DrawerState(DrawerValue.Closed) }
    val scope = rememberCoroutineScope()
    val navigationItems = listOf("Item 1", "Item 2", "Item 3", "Item 4")

//    ModalNavigationDrawer(
//
//    ) { }
//    Column(modifier = Modifier.padding(16.dp)) {
//        var name by remember { mutableStateOf("") }
//        Text(
//            text = "Hello! $name",
//            modifier = Modifier.padding(bottom = 8.dp),
//            style = MaterialTheme.typography.bodyMedium
//        )
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Name") }
//        )
//    }

    MessageCard(Message("Quentin", "Test"))
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    LanguageTeacherAppTheme {
        MainScreen()
    }
}
