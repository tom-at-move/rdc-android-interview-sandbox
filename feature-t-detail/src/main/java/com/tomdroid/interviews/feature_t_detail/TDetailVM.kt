package com.tomdroid.interviews.feature_t_detail

import androidx.lifecycle.ViewModel
import com.move.rdc_android_interview_sandbox.common.ui.NavigationTarget
import com.move.rdc_android_interview_sandbox.common.ui.RDCNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TDetailVM @Inject constructor(
    val navigator: RDCNavigator
): ViewModel() {

    fun navigateClicked() {
        navigator.navigate(
            navigationTarget = NavigationTarget.DemoFragmentTarget()
        )
    }

}