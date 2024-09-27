package com.move.rdc_android_interview_sandbox.demo_fragment_activity

import androidx.lifecycle.ViewModel
import com.move.rdc_android_interview_sandbox.common.ui.RDCNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DemoFragmentActivityVM @Inject constructor(
     private val navigator: RDCNavigator
) : ViewModel() {

     fun navigationTargetStateFlow() = navigator.navigationTargetStateFlow()

}