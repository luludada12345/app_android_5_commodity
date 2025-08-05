package com.example.commodities.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.commodities.modle_class.RewardTicket
import com.example.commodities.modle_class.RewardWeekly

@Composable
fun RewardListItemTicket(
    rewardTicket: RewardTicket,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = rewardTicket.inviterUserId,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = rewardTicket.eventTimeClick,
                color = Color.Gray,
                fontSize = 16.sp,
            )
        }
    }
}



@Composable
fun RewardListItemWeekly(
    rewardWeekly: RewardWeekly,
    onUploadProofClick: () -> Unit,
    onLookupProofClick: () -> Unit,
    onShareClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        val showUploadButton = true      // 控制“上传付款凭证”是否显示
        val showConfirmButton = false    // 控制“确认收到款项”是否显示
        val showTimeoutButton = true     // 控制“超时依然没有收到款项”是否显示

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = rewardWeekly.advertiserId,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "付款凭证:" + "https://d19nxc19f8un0f.cloudfront.net/head.jpg",
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.clickable { onLookupProofClick() },
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                if (showUploadButton) {
                    Button(
                        onClick = { onUploadProofClick() },
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text("上传付款凭证")
                    }
                }
                if (showConfirmButton) {
                    OutlinedButton(
                        onClick = { onShareClick() },
                        shape = RoundedCornerShape(8.dp),
                    ) {
                        Text("确认收到款项")
                    }
                }
                if (showTimeoutButton) {
                    TextButton(
                        onClick = { onSaveClick() },
                    ) {
                        Text("超时依然没有收到")
                    }
                }
            }
        }
    }
}
