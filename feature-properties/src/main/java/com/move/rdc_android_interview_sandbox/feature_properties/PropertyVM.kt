package com.move.rdc_android_interview_sandbox.feature_properties

import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.move.rdc_android_interview_sandbox.data.db.entities.PropertyEntity
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PropertyVM @Inject constructor(
    private val propertyRepo: PropertyRepo
): ViewModel() {

    private val _viewStateFlow = MutableStateFlow<ViewState>(ViewState.Empty)

    fun fetchRequest() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                propertyRepo.syncProperties()
            }
        }
    }

    sealed class ViewState {
        object Empty: ViewState()
        data class Content(val propertyList: List<PropertyEntity>): ViewState()
    }
}