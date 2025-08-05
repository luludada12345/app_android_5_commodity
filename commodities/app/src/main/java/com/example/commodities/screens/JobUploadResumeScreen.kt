package com.example.commodities.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.commodities.modle_class.Resume
import com.example.commodities.modle_class.resumeInit

@Composable
fun JobUploadResumeScreen(
    navController: NavController,
) {
    val resume = resumeInit
    var name by remember { mutableStateOf(resume.name) }
    var email by remember { mutableStateOf(resume.email) }
    var phone by remember { mutableStateOf(resume.phone) }
    var education by remember { mutableStateOf(resume.education) }
    var workExp by remember { mutableStateOf(resume.workExp) }
    var bio by remember { mutableStateOf(resume.bio) }
    var avatarUri by remember { mutableStateOf(resume.avatarUri) }
    var pdfUri by remember { mutableStateOf(resume.pdfUri) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("姓名") })
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("邮箱") })
        OutlinedTextField(value = phone, onValueChange = { phone = it }, label = { Text("手机") })
        OutlinedTextField(
            value = education,
            onValueChange = { education = it },
            label = { Text("学历") })
        OutlinedTextField(
            value = workExp,
            onValueChange = { workExp = it },
            label = { Text("工作经历") })
        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text("自我介绍") },
            modifier = Modifier.height(100.dp)
        )
        Button(onClick = { /* 实现图片选择器，选择后设置 avatarUri */ }) {
            Text("上传头像")
        }
        avatarUri?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
        }

        // PDF上传
        Button(onClick = { /* 实现PDF选择器，选择后设置 pdfUri */ }) {
            Text("上传PDF简历")
        }
        pdfUri?.let { Text(text = "已上传：${it.lastPathSegment}") }

        Spacer(modifier = Modifier.height(16.dp))
        // 保存按钮
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("提交简历")
        }
    }
}
