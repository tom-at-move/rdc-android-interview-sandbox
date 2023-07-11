package com.tomdroid.interviews.feature_b

import androidx.lifecycle.ViewModel
import com.move.rdc_android_interview_sandbox.common.ui.NavigationTarget
import com.move.rdc_android_interview_sandbox.common.ui.RDCNavigator
import com.tomdroid.interviews.shared_a_b.FeatureSharedABManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureBVM @Inject constructor(
    private val navigator: RDCNavigator,
    private val sharedABManager: FeatureSharedABManager
): ViewModel() {

    fun provideDisplayText() = sharedABManager.inputTextState()

    fun setTextState(text: String) {
        sharedABManager.setInputTextState(text)
    }

    fun navigateClicked() {
        navigator.navigate(
            navigationTarget = NavigationTarget.FeatureAFragmentTarget()
        )
    }

}