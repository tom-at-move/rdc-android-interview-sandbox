package com.move.rdc_android_interview_sandbox.models

data class Property(
    var address: Address,

    var price: Int,

    var photos: List<Photo>?

)