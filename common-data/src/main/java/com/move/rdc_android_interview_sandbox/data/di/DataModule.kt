package com.move.rdc_android_interview_sandbox.data.di

import android.content.Context
import androidx.room.Room
import com.move.rdc_android_interview_sandbox.data.db.AppDatabase
import com.move.rdc_android_interview_sandbox.data.db.daos.PropertyDao
import com.move.rdc_android_interview_sandbox.data.network.BASE_URL
import com.move.rdc_android_interview_sandbox.data.network.PropertyApi
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepo
import com.move.rdc_android_interview_sandbox.data.repos.PropertyRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePropertyApi(retrofit: Retrofit): PropertyApi {
        return retrofit.create(PropertyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDb(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "properties-interview"
        ).build()
    }

    @Provides
    @Singleton
    fun providePropertyDao(appDatabase: AppDatabase): PropertyDao {
        return appDatabase.propertyDao()
    }

    @Provides
    @Singleton
    fun providePropertyRepo(
        propertyApi: PropertyApi,
        propertyDao: PropertyDao
    ): PropertyRepo {
        return PropertyRepoImpl(
            propertyApi = propertyApi,
            propertyDao = propertyDao
        )
    }

}