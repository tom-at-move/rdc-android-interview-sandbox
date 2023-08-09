package com.move.rdc_android_interview_sandbox

import app.cash.turbine.test
import com.move.rdc_android_interview_sandbox.common.ui.NavigationTarget
import com.move.rdc_android_interview_sandbox.common.ui.RDCNavigator
import com.move.rdc_android_interview_sandbox.data.db.daos.PropertyDao
import com.move.rdc_android_interview_sandbox.data.models.PropertiesResponse
import com.move.rdc_android_interview_sandbox.data.network.PropertyApi
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepo
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepoImpl
import com.move.rdc_android_interview_sandbox.feature_properties.PropertyListFragmentVM
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class PropertyListFragmentVMTest {


    private lateinit var sut: PropertyListFragmentVM
    private val mockPropertyApi: PropertyApi = mockk(relaxed = true)
    private val mockDao: PropertyDao = mockk(relaxed = true)
    private val mockNavigator: RDCNavigator = mockk(relaxed = true)
    private val mockPropertyRepo: PropertyRepo = PropertyRepoImpl(
        propertyApi = mockPropertyApi,
        propertyDao = mockDao
    )

    @Test
    fun `given onFetchButtonPressed() is invoked and api returns success response, should update viewStateFlow with Viewstate_Content`() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        sut = PropertyListFragmentVM(
            propertyRepo = mockPropertyRepo,
            navigator = mockNavigator
        )

        coEvery { mockDao.getAll() } returns flowOf(listOf())
        coEvery { mockPropertyApi.getProperties() } returns Response.success(PropertiesResponse(listOf()))

        sut.viewStateFlow().test {
            assertEquals(PropertyListFragmentVM.ViewState.Empty, awaitItem())
            sut.onFetchButtonPress()
            assertEquals(PropertyListFragmentVM.ViewState.Loading, awaitItem())
            assertEquals(PropertyListFragmentVM.ViewState.Content(listOf()), awaitItem())
            expectNoEvents()
        }
    }

    @Test
    fun `given onNavigateButtonPressed() is invoked, navigator should emit event`() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        sut = PropertyListFragmentVM(
            propertyRepo = mockPropertyRepo,
            navigator = mockNavigator
        )


        sut.onNavigateButtonPress()

        verify {
            mockNavigator.navigate(NavigationTarget.PropertyFragmentTarget())
        }
    }

}