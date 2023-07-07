package com.move.rdc_android_interview_sandbox.common.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestComponent() {


    LazyColumn {
        // Add a single item
        item {
            Text(text = "First item")
        }

        // Add 5 items
        items(5) { index ->
            Text(text = "Item: $index")
        }

        item {
            BeautifulComponent()
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TestComponent_Preview() {
    TestComponent()
}