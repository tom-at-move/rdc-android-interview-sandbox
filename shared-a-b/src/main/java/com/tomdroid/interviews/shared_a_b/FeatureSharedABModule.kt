package com.tomdroid.interviews.shared_a_b

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
class FeatureSharedABModule {

    @Provides
    @ActivityRetainedScoped
    fun provideSharedABManager(): FeatureSharedABManager {
        return FeatureSharedABManager()
    }

}