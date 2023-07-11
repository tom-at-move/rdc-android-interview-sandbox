package com.tomdroid.interviews.feature_b

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import com.move.rdc_android_interview_sandbox.common.ui.components.EditTextComponent
import com.move.rdc_android_interview_sandbox.common.ui.screens.ComposeHarnessFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureBFragment : ComposeHarnessFragment() {

    private val vm: FeatureBVM by viewModels()

    @Composable
    override fun renderComposeView() {

        Column() {

            Text(text = "We are in Feature B Fragment")

            val textDisplay = vm.provideDisplayText().collectAsState().value
            Text(text = textDisplay)

            EditTextComponent(
                onValueChange = {
                    vm.setTextState(it)
                })

            Button(onClick = {
                vm.navigateClicked()
            }) {
                Text(text = "NAVIGATE TO A!!!")
            }

        }
    }

}