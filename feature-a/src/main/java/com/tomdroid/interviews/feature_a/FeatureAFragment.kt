package com.tomdroid.interviews.feature_a

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
class FeatureAFragment : ComposeHarnessFragment() {

    private val vm: FeatureAVM by viewModels()

    @Composable
    override fun renderComposeView() {

        Column {

            Text(text = "We are in Feature A Fragment")

            val textDisplay = vm.provideDisplayText().collectAsState().value
            Text(text = textDisplay)

            EditTextComponent(
                onValueChange = {
                    vm.setTextState(it)
                })

            Button(onClick = {
                vm.navigateClicked()
            }) {
                Text(text = "NAVIGATE TO B!!!")
            }

        }
    }

}