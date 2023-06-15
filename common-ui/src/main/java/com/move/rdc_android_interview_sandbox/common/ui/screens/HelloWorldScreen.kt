package com.move.rdc_android_interview_sandbox.common.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.move.rdc_android_interview_sandbox.common.ui.components.HelloWorldComponent

@Composable
fun HelloWorldScreen() {
    Column {
        HelloWorldComponent()
    }
}

@Preview
@Composable
fun HelloWorldScreenPreview() {
    HelloWorldScreen()
}