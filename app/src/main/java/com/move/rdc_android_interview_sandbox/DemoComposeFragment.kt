package com.move.rdc_android_interview_sandbox

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.move.rdc_android_interview_sandbox.common.ui.components.EditTextComponent
import com.move.rdc_android_interview_sandbox.common.ui.components.GoodbyeWorldComponent
import com.move.rdc_android_interview_sandbox.common.ui.components.HelloWorldComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DemoComposeFragment : Fragment() {

    private val vm: DemoComposeFragmentVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                DemoComposeFragmentScreen()
            }
        }
    }

    @Composable
    fun DemoComposeFragmentScreen() {

        Column(
            modifier = Modifier.fillMaxSize()
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
                    vm.onNavigateButtonPress()
                }
            ) {
                Text(
                    text="Sample Navigation"
                )
            }

            when (val viewState = vm.viewStateFlow().collectAsState().value) {

                is DemoComposeFragmentVM.ViewState.Content -> {
                    LazyColumn {
                        items(viewState.propertyEntities) {
                            Text(text = it.address.line)
                        }
                    }
                }

                DemoComposeFragmentVM.ViewState.Loading -> {
                    CircularProgressIndicator()
                }

                DemoComposeFragmentVM.ViewState.Empty -> {
                    HelloWorldComponent()
                    GoodbyeWorldComponent()
                    EditTextComponent(
                        onValueChange = {
                            Log.d(this::class.java.toString(), it)
                        }
                    )
                }

                DemoComposeFragmentVM.ViewState.SyncError -> {
                    Snackbar {
                        Text(text ="Error")
                    }
                }
            }

        }
    }

    companion object {
        fun newInstance(): DemoComposeFragment {
            return DemoComposeFragment()
        }
    }

}