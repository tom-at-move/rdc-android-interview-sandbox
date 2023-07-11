package com.tomdroid.interviews.shared_a_b

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class FeatureSharedABVM @Inject constructor(): ViewModel() {

    private val _inputTextState = MutableStateFlow("Init State")

    fun inputTextState() = _inputTextState.asStateFlow()

    fun setInputTextState(value: String) {
        _inputTextState.value = value
    }

}