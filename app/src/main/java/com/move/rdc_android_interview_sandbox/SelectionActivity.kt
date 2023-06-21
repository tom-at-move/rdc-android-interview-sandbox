package com.move.rdc_android_interview_sandbox

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.move.rdc_android_interview_sandbox.databinding.ActivitySelectionBinding
import com.move.rdc_android_interview_sandbox.demo_fragment_activity.DemoFragmentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectionActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewActivityButton.setOnClickListener {
            val intent = Intent(this@SelectionActivity, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        binding.fragmentActivityButton.setOnClickListener {
            val intent = Intent(this@SelectionActivity, DemoFragmentActivity::class.java)
            startActivity(intent)
        }

        binding.composeActivityButton.setOnClickListener {
            val intent = Intent(this@SelectionActivity, ComposeDemoActivity::class.java)
            startActivity(intent)
        }

    }

}