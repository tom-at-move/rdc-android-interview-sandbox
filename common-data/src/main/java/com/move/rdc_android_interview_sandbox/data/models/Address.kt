package com.move.rdc_android_interview_sandbox.data.models

data class Address (
    var city: String,

    var line: String,

    val postalCode: String? = null,

    val stateCode: String? = null,

    var state: String,
)
