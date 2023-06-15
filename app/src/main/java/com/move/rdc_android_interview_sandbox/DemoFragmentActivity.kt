package com.move.rdc_android_interview_sandbox

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.move.rdc_android_interview_sandbox.databinding.ActivityDemoFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DemoFragmentActivity: FragmentActivity() {

    private lateinit var binding: ActivityDemoFragmentBinding

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigator.setNavigationCallbackListener {
            val theFragmentToGoto = navigator.navToDestination("", "Hello")

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, theFragmentToGoto)
            .commit()
        }


    }

}