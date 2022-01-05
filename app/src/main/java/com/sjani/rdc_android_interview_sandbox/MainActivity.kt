package com.sjani.rdc_android_interview_sandbox

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sjani.rdc_android_interview_sandbox.models.Property

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainListAdapter
    val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        viewModel.setUpdateListener(object : MainViewModel.UpdateListener {
            override fun onUpdate(properties: List<Property>) = renderPropertyList(properties)
        })
    }

    private fun renderPropertyList(properties: List<Property>) {

    }

    private fun bindViews() {
        recyclerView = findViewById(R.id.list_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainListAdapter(this)
        recyclerView.adapter = adapter
    }
}