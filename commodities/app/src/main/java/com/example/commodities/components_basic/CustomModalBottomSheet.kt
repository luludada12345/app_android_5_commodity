package com.example.commodities.components_basic

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.ui.draw.clip
import androidx.core.net.toUri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModalBottomSheet(
    navController: NavController,
    context: Context,
    show: Boolean,
    onDismiss: () -> Unit,
    onOptionClick: () -> Unit
) {
    if (show) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = rememberModalBottomSheetState(
                skipPartiallyExpanded = true
            ),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // 左右间距
                    .clip(RoundedCornerShape(16.dp)) // 圆角
                    .wrapContentHeight()
            ) {
                CustomModalBottomSheetOption("拉新佣金计算方法", true) {
                    onOptionClick()
                    navController.navigate("protocol/reward")
                }
                CustomModalBottomSheetOption("工厂入驻须知", true) {
                    onOptionClick()
                    navController.navigate("protocol/store")
                }
                CustomModalBottomSheetOption("节点入驻须知", true) {
                    onOptionClick()
                    navController.navigate("protocol/factory")
                }
                CustomModalBottomSheetOption("长期采购，申请折扣") {
                    onOptionClick()
                    navController.navigate("protocol/discount")
                }
                CustomModalBottomSheetOption("我的二维码、获取用户位置") {
                    onOptionClick()
                    navController.navigate("qrcode")
                }
                CustomModalBottomSheetOption("下载电商APP") {
                    onOptionClick()
                    //  不需要判断平台，因为IOS的是在xcode中用swift代码实现
                    val url =
                        "https://play.google.com/store/apps/details?id=com.facebook.katana"
                    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                    context.startActivity(intent)
                }
                CustomModalBottomSheetOption("编辑简历") {
                    onOptionClick()
                    navController.navigate("jobResumeEdit")
                }
                CustomModalBottomSheetOption("我的简历") {
                    onOptionClick()
                    navController.navigate("jobResume")
                }
                if (!show) {
                    CustomModalBottomSheetOption("上传视频") {
                        onOptionClick()
                        navController.navigate("videoUpload")
                    }
                    CustomModalBottomSheetOption("我投递的职位") {
                        onOptionClick()
                        navController.navigate("jobList/true")
                    }
                    CustomModalBottomSheetOption("我报名的活动") {
                        onOptionClick()
                        navController.navigate("activityList/true")
                    }
                    CustomModalBottomSheetOption("我的佣金（逐笔）（双方）") {
                        onOptionClick()
                        navController.navigate("rewardTicket")
                    }
                    CustomModalBottomSheetOption("我的佣金（每周统计）（也是双方）") {
                        onOptionClick()
                        navController.navigate("rewardWeekly")
                    }
                }
            }
        }
    }
}
