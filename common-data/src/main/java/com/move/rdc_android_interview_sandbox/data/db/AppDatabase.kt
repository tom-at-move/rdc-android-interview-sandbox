package com.move.rdc_android_interview_sandbox.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.move.rdc_android_interview_sandbox.data.db.daos.PropertyDao
import com.move.rdc_android_interview_sandbox.data.db.entities.PropertyEntity

@Database(entities = [PropertyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun propertyDao(): PropertyDao
}