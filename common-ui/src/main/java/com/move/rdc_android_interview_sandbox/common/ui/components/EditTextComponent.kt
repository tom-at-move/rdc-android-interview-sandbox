package com.move.rdc_android_interview_sandbox.common.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextComponent(
    initialValue: String = "",
    onValueChange: (String) -> Unit
) {

    val textInput = remember {
        mutableStateOf(initialValue)
    }

    TextField(
        value = textInput.value,
        onValueChange = { theValue: String ->
            textInput.value = theValue
            onValueChange.invoke(theValue)
        }
    )

}

@Preview
@Composable
fun EditTextComponentPreview() {
    EditTextComponent(
        initialValue = "Hello",
        onValueChange = {

        }
    )
}