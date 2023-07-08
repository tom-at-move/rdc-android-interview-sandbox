package com.move.rdc_android_interview_sandbox.demo_fragment_activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.move.rdc_android_interview_sandbox.DemoComposeFragment
import com.move.rdc_android_interview_sandbox.R
import com.move.rdc_android_interview_sandbox.common.ui.NavigationTarget
import com.move.rdc_android_interview_sandbox.databinding.ActivityDemoFragmentBinding
import com.move.rdc_android_interview_sandbox.feature_properties.PropertyFragment
import com.tomdroid.interviews.feature_t_detail.TDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DemoFragmentActivity: FragmentActivity() {

    private lateinit var binding: ActivityDemoFragmentBinding

    private val vm: DemoFragmentActivityVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            withContext(Dispatchers.IO) {

                vm.screenBackStackStateFlow()
                    .collectLatest { theCurrentBackStack: ArrayDeque<NavigationTarget> ->

                        val destinationFragment = when (theCurrentBackStack.firstOrNull()) {

                            is NavigationTarget.DemoFragmentTarget -> {
                                DemoComposeFragment.newInstance()
                            }

                            is NavigationTarget.PropertyFragmentTarget -> {
                                PropertyFragment.newInstance()
                            }

                            is NavigationTarget.TDetailFragmentTarget -> {
                                TDetailFragment()
                            }

                            null -> {
                                null
                            }
                        }


                        if (destinationFragment != null) {
                            supportFragmentManager
                                .beginTransaction()
                                .replace(
                                    R.id.fragment_container,
                                    destinationFragment,
                                    destinationFragment.tag
                                )
                                .commit()

                        }

                    }
            }

        }

    }
    override fun onBackPressed() {

        vm.onBackPressed()

        if (vm.isBackStackEmpty()) {
            super.onBackPressed()
        }
    }

}