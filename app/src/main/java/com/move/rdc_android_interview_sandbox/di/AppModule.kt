package com.move.rdc_android_interview_sandbox.di

import com.move.rdc_android_interview_sandbox.common.ui.RDCNavigator
import com.move.rdc_android_interview_sandbox.common.ui.RDCNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideNavigator(): RDCNavigator {
        return RDCNavigatorImpl()
    }

}