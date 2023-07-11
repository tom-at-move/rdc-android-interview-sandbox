package com.move.rdc_android_interview_sandbox

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.move.rdc_android_interview_sandbox.databinding.ActivitySelectionBinding
import com.move.rdc_android_interview_sandbox.demo_fragment_activity.MainNavigatorActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectionActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentActivityButton.setOnClickListener {
            val intent = Intent(this@SelectionActivity, MainNavigatorActivity::class.java)
            startActivity(intent)
        }

    }

}