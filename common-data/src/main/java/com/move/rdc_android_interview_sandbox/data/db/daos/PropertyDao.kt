package com.move.rdc_android_interview_sandbox.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.move.rdc_android_interview_sandbox.data.db.entities.PropertyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PropertyDao {

    @Insert
    fun insertAll(propertyEntities: List<PropertyEntity>)

    @Query("SELECT * FROM PropertyEntity")
    fun getAll(): Flow<List<PropertyEntity>>

}