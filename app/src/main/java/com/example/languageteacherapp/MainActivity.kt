package com.example.languageteacherapp

import SampleData
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.languageteacherapp.data.model.Message
import com.example.languageteacherapp.ui.components.ChatBar
import com.example.languageteacherapp.ui.components.Messages.Conversation
import com.example.languageteacherapp.ui.components.SideDrawer
import com.example.languageteacherapp.ui.components.TopBar
import com.example.languageteacherapp.ui.theme.LanguageTeacherAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LanguageTeacherAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var messageInput by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(SampleData.conversationSample) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            SideDrawer(
                onLanguageClick = { language ->
                    // Handle language click here
                    println("Clicked on $language")
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    title = "Conversation",
                    onMenuClick = {
                        scope.launch { drawerState.open() }
                    }
                )
            },
            bottomBar = {
                ChatBar(
                    messageInput = messageInput,
                    onMessageChange = { messageInput = it },
                    onSendClick = {
                        if (messageInput.isNotBlank()) {
                            messages = messages + Message("Quentin", messageInput)
                            messageInput = ""
                        }
                    }
                )
            }
        ) { paddingValues ->
            Conversation(Modifier.padding(paddingValues), messages)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LanguageTeacherAppTheme {
        MainScreen()
    }
}
