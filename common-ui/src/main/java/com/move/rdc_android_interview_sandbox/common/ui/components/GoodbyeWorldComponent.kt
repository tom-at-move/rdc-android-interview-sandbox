package com.move.rdc_android_interview_sandbox.common.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GoodbyeWorldComponent() {
    Column {
        Text("Goodbye Single-Module World")
    }
}

@Preview(
    showBackground = true
)
@Composable
fun GoodbyeWorldComponentPreview() {
    GoodbyeWorldComponent()
}