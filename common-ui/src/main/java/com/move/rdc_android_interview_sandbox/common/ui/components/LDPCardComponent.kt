package com.move.rdc_android_interview_sandbox.common.ui.components

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun LDPCardComponent() {
    val context = LocalContext.current
    AndroidView(
        factory = {
            TextView(context)
        }
    ) {
        it.text = "Hello View Based Interop"
    }


}