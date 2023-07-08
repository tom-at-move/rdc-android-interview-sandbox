package com.move.rdc_android_interview_sandbox.common.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
abstract class ComposeHarnessFragment: Fragment() {

    @Composable
    abstract fun renderComposeView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                renderComposeView()
            }
        }
    }

}