package com.move.rdc_android_interview_sandbox

import app.cash.turbine.test
import com.move.rdc_android_interview_sandbox.data.db.daos.PropertyDao
import com.move.rdc_android_interview_sandbox.data.models.PropertiesResponse
import com.move.rdc_android_interview_sandbox.data.network.PropertyApi
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepo
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepoImpl
import io.mockk.coEvery
import io.mockk.mockk
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
class DemoComposeFragmentVMTest {


    private lateinit var sut: DemoComposeFragmentVM
    private val mockPropertyApi: PropertyApi = mockk(relaxed = true)
    private val mockDao: PropertyDao = mockk(relaxed = true)
    private val mockPropertyRepo: PropertyRepo = PropertyRepoImpl(
        propertyApi = mockPropertyApi,
        propertyDao = mockDao
    )

    @Test
    fun `given onFetchButtonPressed() is invoked and api returns success response, should update viewStateFlow with Viewstate_Content`() = runTest {
        val testDispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)

        sut = DemoComposeFragmentVM(
            propertyRepo = mockPropertyRepo
        )

        coEvery { mockDao.getAll() } returns flowOf(listOf())
        coEvery { mockPropertyApi.getProperties() } returns Response.success(PropertiesResponse(listOf()))

        sut.viewStateFlow().test {
            assertEquals(awaitItem(), DemoComposeFragmentVM.ViewState.Empty)
            sut.onFetchButtonPress()
            assertEquals(awaitItem(), DemoComposeFragmentVM.ViewState.Loading)
            assertEquals(awaitItem(), DemoComposeFragmentVM.ViewState.Content(listOf()))
            expectNoEvents()
        }
    }

}