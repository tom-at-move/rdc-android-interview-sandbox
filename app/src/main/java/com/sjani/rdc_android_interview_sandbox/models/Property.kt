package com.sjani.rdc_android_interview_sandbox.models

import com.sjani.rdc_android_interview_sandbox.util.CurrencyHelper

data class Property(
    var address: Address,

    var price: Int,

    var photos: List<Photo>?

)