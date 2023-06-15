package com.move.rdc_android_interview_sandbox

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.move.rdc_android_interview_sandbox.databinding.ActivityDemoFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {

                navigator
                    .navigationTargetStateFlow()
                    .collectLatest { theLocation ->
                    val destinationFragment = navigator.buildFragmentDestinationByTag(theLocation, "payload-here")

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, destinationFragment)
                        .commit()
                }
            }
        }

    }

}