package com.tomdroid.interviews.feature_t_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.move.rdc_android_interview_sandbox.common.ui.screens.ComposeHarnessFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TDetailFragment : ComposeHarnessFragment() {

    private val tDetailVM: TDetailVM by viewModels()

    @Composable
    override fun renderComposeView() {

        Column() {

            Button(onClick = {
                tDetailVM.navigateClicked()
            }) {
                Text(text = "NAVIGATE TTTTTT!!!")
            }

        }
    }

}