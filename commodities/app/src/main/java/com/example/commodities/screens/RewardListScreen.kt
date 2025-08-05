package com.example.commodities.screens

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.example.commodities.components.RewardListItemTicket
import com.example.commodities.components.RewardListItemWeekly
import com.example.commodities.modle_class.rewardTicketInit
import com.example.commodities.modle_class.rewardWeeklyInit

@Composable
fun RewardListScreen(navController: NavController, context: Context) {
    val rewardTickets = rewardTicketInit
    val rewardWeeklys = rewardWeeklyInit

    LazyColumn {
        items(rewardTickets) { rewardTicket ->
            RewardListItemTicket(
                rewardTicket = rewardTicket,
            )
        }

        items(rewardWeeklys) { rewardWeekly ->
            RewardListItemWeekly(
                rewardWeekly = rewardWeekly,
                onUploadProofClick = { navController.navigate("rewardUploadPaymentProof") },
                onLookupProofClick = {
                    // 图片、文件按，都给一个链接（储存在S3的或者pre-signed-url），都在浏览器中打开
                    val url = "https://d19nxc19f8un0f.cloudfront.net/head.jpg"
                    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                    // 指定只用浏览器打开（可选）
                    intent.addCategory(Intent.CATEGORY_BROWSABLE)
                    context.startActivity(intent)
                },
                onShareClick = { },
                onSaveClick = { },
            )
        }
    }
}
