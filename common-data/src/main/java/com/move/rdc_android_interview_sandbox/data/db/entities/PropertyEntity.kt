package com.move.rdc_android_interview_sandbox.data.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.move.rdc_android_interview_sandbox.data.models.Address
import com.move.rdc_android_interview_sandbox.data.models.Photo

@Entity
data class PropertyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Embedded val address: Address,
    @Embedded val photo: Photo,
    val price: Int
)

