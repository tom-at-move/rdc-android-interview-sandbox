package com.move.rdc_android_interview_sandbox

import androidx.lifecycle.ViewModel
import com.move.rdc_android_interview_sandbox.models.Property
import com.move.rdc_android_interview_sandbox.util.getTestList

class MainViewModel() : ViewModel() {

    interface UpdateListener {
        fun onUpdate(properties: List<Property>)
    }

    private var properties: List<Property>
    private var listener: UpdateListener? = null

    init {
        properties = getTestList()
    }

    fun setUpdateListener(listener: UpdateListener?) {
        this.listener = listener
        listener?.onUpdate(properties)
    }

}