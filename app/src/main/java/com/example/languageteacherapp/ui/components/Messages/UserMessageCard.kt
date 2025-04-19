package com.example.languageteacherapp.ui.components.Messages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.languageteacherapp.R
import com.example.languageteacherapp.data.model.Message
import com.example.languageteacherapp.ui.theme.messagePaddingToScreenEdge


@Composable
fun UserMessageCard(
    message: Message
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        Spacer(modifier = Modifier.width(messagePaddingToScreenEdge))
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.End,
        ) {
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = message.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                    Text(
                        text = message.body,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
        Image(
            painter = painterResource(R.drawable.pp),
            contentDescription = "profile pic",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
    }
}

@Preview
@Composable
fun UserMessageCardPreview() {
//    UserMessageCard(Message("Quentin", "Comment ca va ?"))
    UserMessageCard(Message("Quentin", "Comment ca va ?das fdsa akjolhf oiadshjf oasodfj asdf j"))
}