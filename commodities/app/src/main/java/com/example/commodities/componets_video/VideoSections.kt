package com.example.commodities.componets_video

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.commodities.modle_class.VideoItem

@Composable
fun VideoInfoSection(
    video: VideoItem,
    onFollowClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = video.authorAvatar,
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.White, CircleShape)
            )
            Spacer(Modifier.width(8.dp))
            Text(video.authorName, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(Modifier.width(8.dp))
            if (!video.isFollowed) {
                Button(
                    onClick = onFollowClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) { Text("+ 关注") }
            }
        }
        Text(
            text = video.description,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun VideoActionSection(
    video: VideoItem,
    onLikeClick: () -> Unit,
    onCommentClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(end = 16.dp, bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onLikeClick) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Like",
                tint = if (video.isLiked) Color.Red else Color.White
            )
        }
        Text("${video.likeCount}", color = Color.White)
        Spacer(Modifier.height(12.dp))
        IconButton(onClick = onCommentClick) {
            Icon(Icons.AutoMirrored.Filled.Comment, "Comment", tint = Color.White)
        }
        Text("${video.commentCount}", color = Color.White)
        Spacer(Modifier.height(12.dp))
        IconButton(onClick = onShareClick) {
            Icon(Icons.Filled.Share, "Share", tint = Color.White)
        }
        Text("${video.shareCount}", color = Color.White)
    }
}
