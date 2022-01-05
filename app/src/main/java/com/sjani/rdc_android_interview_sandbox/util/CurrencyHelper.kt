package com.sjani.rdc_android_interview_sandbox.util

import java.text.NumberFormat

class CurrencyHelper {
    internal val currencyInstance: NumberFormat = NumberFormat.getCurrencyInstance()

    init {
        currencyInstance.maximumFractionDigits = 0
    }

    companion object {
        val instance = CurrencyHelper()
    }
}