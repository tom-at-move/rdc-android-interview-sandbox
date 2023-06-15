package com.move.rdc_android_interview_sandbox.data.models

data class Property(
    var address: Address,

    var price: Int,

    var photos: List<Photo>?

)