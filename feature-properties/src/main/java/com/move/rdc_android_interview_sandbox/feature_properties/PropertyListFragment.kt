package com.move.rdc_android_interview_sandbox.feature_properties

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.fragment.app.viewModels
import com.move.rdc_android_interview_sandbox.common.ui.components.EditTextComponent
import com.move.rdc_android_interview_sandbox.common.ui.components.GoodbyeWorldComponent
import com.move.rdc_android_interview_sandbox.common.ui.components.HelloWorldComponent
import com.move.rdc_android_interview_sandbox.common.ui.screens.ComposeHarnessFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PropertyListFragment : ComposeHarnessFragment() {

    private val vm: PropertyListFragmentVM by viewModels()

    @Composable
    override fun renderComposeView() {
        PropertyListFragmentScreen()
    }

    @Composable
    fun PropertyListFragmentScreen() {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    vm.onFetchButtonPress()
                }
            ) {
                Text(
                    text="Sample API Call"
                )
            }

            Button(
                onClick = {
                    vm.onDeleteAll()
                }
            ) {
                Text(
                    text="Delete All"
                )
            }



            when (val viewState: PropertyListFragmentVM.ViewState = vm.viewStateFlow().collectAsState().value) {

                is PropertyListFragmentVM.ViewState.Content -> {
                    LazyColumn {
                        items(viewState.propertyEntities) {
                            Text(text = it.address.line)
                        }
                    }
                }

                PropertyListFragmentVM.ViewState.Loading -> {
                    CircularProgressIndicator()
                }

                PropertyListFragmentVM.ViewState.Empty -> {
                    HelloWorldComponent()
                    GoodbyeWorldComponent()
                    EditTextComponent(
                        onValueChange = {
                            Log.d(this::class.java.toString(), it)
                        }
                    )
                }

                PropertyListFragmentVM.ViewState.SyncError -> {
                    Snackbar {
                        Text(text ="Error")
                    }
                }
            }

        }
    }

    companion object {
        fun newInstance(): PropertyListFragment {
            return PropertyListFragment()
        }
    }

}