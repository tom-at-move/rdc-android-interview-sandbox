package com.tomdroid.interviews.feature_a

import androidx.lifecycle.ViewModel
import com.move.rdc_android_interview_sandbox.common.ui.NavigationTarget
import com.move.rdc_android_interview_sandbox.common.ui.RDCNavigator
import com.tomdroid.interviews.shared_a_b.FeatureSharedABManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureAVM @Inject constructor(
    private val navigator: RDCNavigator,
    private val sharedABManager: FeatureSharedABManager
): ViewModel() {

    fun provideDisplayText() = sharedABManager.inputTextState()

    fun setTextState(text: String) {
        sharedABManager.setInputTextState(text)
    }

    fun navigateToBClicked() {
        navigator.navigate(
            navigationTarget = NavigationTarget.FeatureBFragmentTarget()
        )
    }

    fun navigateToPropertyList() {
        navigator.navigate(
            navigationTarget = NavigationTarget.PropertyListFragmentTarget()
        )
    }

    sealed class ViewState {
        data class Content(val text: String)
    }

}