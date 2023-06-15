package com.move.rdc_android_interview_sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.move.rdc_android_interview_sandbox.common.ui.screens.HelloWorldScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeDemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloWorldScreen()
        }
    }
}