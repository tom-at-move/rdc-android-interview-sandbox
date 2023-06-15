package com.move.rdc_android_interview_sandbox

import androidx.fragment.app.Fragment
import com.move.rdc_android_interview_sandbox.feature_properties.PropertyFragment

//how testable is the native navigation?
// MVVM-C MVI-C
interface Navigator {
    fun setNavigationCallbackListener(listener: (String) -> Unit)
    fun <T> navToDestination(location: String, payload: T): Fragment
}

class NavigatorImpl(): Navigator {

    private var navigationCallbackListener: ((String) -> Unit)? = null

    //probably bad... but is it though?
    private val navigationGraph: Map<String, Fragment> = mapOf(
        "property" to PropertyFragment(),
        "demo_fragment" to DemoComposeFragment()
    )

    override fun <T> navToDestination(location: String, payload: T): Fragment {
        navigationCallbackListener?.invoke(location)
        return navigationGraph[location] ?: DemoComposeFragment() //default
    }

    override fun setNavigationCallbackListener(listener: (String) -> Unit) {
        navigationCallbackListener = listener
    }


}