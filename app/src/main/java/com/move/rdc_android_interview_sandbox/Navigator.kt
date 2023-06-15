package com.move.rdc_android_interview_sandbox

import androidx.fragment.app.Fragment
import com.move.rdc_android_interview_sandbox.feature_properties.PropertyFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//how testable is the native navigation?
// MVVM-C MVI-C
interface Navigator {
    fun setNavigationCallbackListener(listener: (String) -> Unit)
    fun <T> buildFragmentDestinationByTag(location: String, payload: T): Fragment

    fun navigationTargetStateFlow(): StateFlow<String>

    fun <T> navigateToTarget(location: String, payload: T)
}

class NavigatorImpl(): Navigator {

    private var navigationCallbackListener: ((String) -> Unit)? = null

    private val _navigationTargetFlow = MutableStateFlow("demo_fragment")

    //probably bad... but is it though?
    private val navigationGraph: Map<String, Fragment> = mapOf(
        NavigationTarget.PropertyFragment to PropertyFragment(),
        NavigationTarget.DemoFragment to DemoComposeFragment()
    )

    override fun <T> buildFragmentDestinationByTag(location: String, payload: T): Fragment {
        navigationCallbackListener?.invoke(location)
        return navigationGraph[location] ?: DemoComposeFragment() //default
    }

    override fun setNavigationCallbackListener(listener: (String) -> Unit) {
        navigationCallbackListener = listener
    }

    override fun navigationTargetStateFlow(): StateFlow<String> {
        return _navigationTargetFlow.asStateFlow()
    }

    override fun <T> navigateToTarget(location: String, payload: T) {
        _navigationTargetFlow.value = location
    }

}

object NavigationTarget {
    const val PropertyFragment = "property"
    const val DemoFragment = "demo_fragment"
}