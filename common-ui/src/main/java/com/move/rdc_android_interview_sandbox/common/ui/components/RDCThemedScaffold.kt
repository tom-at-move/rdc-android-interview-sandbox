package com.move.rdc_android_interview_sandbox.common.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RDCThemedScaffold(composeContent: @Composable () -> Unit) {
    Scaffold(
        content = {
            it
        }
    )
}