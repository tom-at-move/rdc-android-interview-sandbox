package com.move.rdc_android_interview_sandbox

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.move.rdc_android_interview_sandbox.data.db.entities.PropertyEntity
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DemoComposeFragmentVM @Inject constructor(
    private val propertyRepo: PropertyRepo,
    private val navigator: Navigator
) : ViewModel() {

    private val _viewStateFlow = MutableStateFlow<ViewState>(ViewState.Empty)

    fun viewStateFlow(): StateFlow<ViewState> = _viewStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                propertyRepo.observeProperties().collectLatest {
                    _viewStateFlow.value = ViewState.Content(
                        propertyEntities = it
                    )
                }
            }
        }
    }

    fun onFetchButtonPress() {
        _viewStateFlow.value = ViewState.Loading
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                propertyRepo.syncProperties()
            }
        }

        navigator.buildFragmentDestinationByTag("", "")
    }

    fun onNavigateButtonPress() {
        navigator.navigateToTarget(NavigationTarget.PropertyFragment, "any-payload-here")
    }


    sealed class ViewState {
        object Empty : ViewState()
        object Loading: ViewState()
        object SyncError: ViewState()
        data class Content(
            val propertyEntities: List<PropertyEntity>
        ): ViewState()
    }

}