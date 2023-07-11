package com.tomdroid.interviews.shared_a_b

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class FeatureSharedABManager {

    private val _inputTextState = MutableStateFlow("Init State")

    fun inputTextState() = _inputTextState.asStateFlow()

    fun setInputTextState(value: String) {
        _inputTextState.value = value
    }

}