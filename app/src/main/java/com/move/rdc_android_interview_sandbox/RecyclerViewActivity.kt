package com.move.rdc_android_interview_sandbox

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerListAdapter
    val viewModel: RecyclerViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        viewModel.setUpdateListener(object : RecyclerViewModel.UpdateListener {
            override fun onUpdate(properties: List<com.move.rdc_android_interview_sandbox.data.models.Property>) = renderPropertyList(properties)
        })
    }

    private fun renderPropertyList(properties: List<com.move.rdc_android_interview_sandbox.data.models.Property>) {

    }

    private fun bindViews() {
        recyclerView = findViewById(R.id.list_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerListAdapter(this)
        recyclerView.adapter = adapter
    }
}