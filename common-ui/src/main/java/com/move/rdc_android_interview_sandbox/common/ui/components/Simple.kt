package com.move.rdc_android_interview_sandbox.common.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimpleTestComponent(
    textToDisplay: String
) {
    Text(
        text = textToDisplay
    )
}


@Composable
@Preview
fun SimpleTestComponent_Preview() {
    SimpleTestComponent(
        textToDisplay = "こんにちは",
    )
}

@Composable
@Preview
fun SimpleTestComponent_Preview2() {
    SimpleTestComponent(
        textToDisplay = "你好吗？！"
    )
}