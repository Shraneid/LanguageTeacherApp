package com.example.languageteacherapp.ui.components.Messages

import SampleData
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.languageteacherapp.data.model.Message

@Composable
fun Conversation(modifier: Modifier = Modifier, messages: List<Message>) {
    LazyColumn(modifier = modifier, reverseLayout = true) {
        items(messages.reversed()) { message ->
            if (message.author == "Linguini")
                MessageCard(message)
            else
                UserMessageCard(message)
        }
    }
}

@Preview
@Composable
fun ConversationProcess() {
    Conversation(messages = SampleData.conversationSample)
}