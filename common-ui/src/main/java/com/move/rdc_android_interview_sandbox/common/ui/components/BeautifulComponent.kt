package com.move.rdc_android_interview_sandbox.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BeautifulComponent() {
        val colorStops = arrayOf(
            0.0f to Color.Red,
            1f to Color.Black
        )
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
        .background(
            Brush.verticalGradient(
                colorStops = colorStops
            )
        )
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            text = "Hello RDC"
        )
    }
}

@Preview
@Composable
fun BeautifulComponent_Preview() {
    BeautifulComponent()
}