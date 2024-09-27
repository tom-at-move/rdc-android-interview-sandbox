package com.move.rdc_android_interview_sandbox.feature_properties

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import com.move.rdc_android_interview_sandbox.common.ui.screens.ComposeHarnessFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PropertyFragment : ComposeHarnessFragment() {

    private val vm: PropertyVM by viewModels()

    @Composable
    override fun renderComposeView() {

        Column {

            Text(text = "Hello!!!")

            Button(
                onClick = {
                    vm.fetchRequest()
                }
            ) {
                Text("Click me")
            }

            Button(
                onClick = {
                    vm.navigateToDemoComposeFragment()
                }
            ) {
                Text("Navigate to demo fragment")
            }
        }

    }

    companion object {
        fun newInstance(): PropertyFragment {
            return PropertyFragment()
        }
    }

}