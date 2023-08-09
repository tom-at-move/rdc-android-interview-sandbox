package com.tomdroid.interviews.feature_a

import android.widget.EditText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.move.rdc_android_interview_sandbox.common.ui.components.EditTextComponent
import com.move.rdc_android_interview_sandbox.common.ui.screens.ComposeHarnessFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureAFragment : ComposeHarnessFragment() {

    private val vm: FeatureAVM by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun renderComposeView() {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "We are in Feature A Fragment")

            val textDisplay = vm.provideDisplayText().collectAsState().value
            Text(text = textDisplay)

            EditTextComponent(
                onValueChange = {
                    vm.setTextState(it)
                })

            Button(
                onClick = {
                    vm.navigateToBClicked()
                }
            ) {
                Text(text = "NAVIGATE TO B!!!")
            }

            Button(onClick = {
                vm.navigateToPropertyList()
            }) {
                Text(text = "NAVIGATE TO PROPERTY LIST!!!")
            }

            Text(
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(8.dp).clickable {
                     println("I am clicked")
                },
                text = "Click me!"
            )

            Button(onClick = {

            }) {
                //put more composable content here
            }


        }
    }

}