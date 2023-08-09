package com.move.rdc_android_interview_sandbox.data.repos

import com.move.rdc_android_interview_sandbox.data.db.daos.PropertyDao
import com.move.rdc_android_interview_sandbox.data.db.entities.PropertyEntity
import com.move.rdc_android_interview_sandbox.data.models.Photo
import com.move.rdc_android_interview_sandbox.data.network.PropertyApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface PropertyRepo {

    suspend fun syncProperties()
    fun observeProperties(): Flow<List<PropertyEntity>>

    fun deleteAll()

}

class PropertyRepoImpl @Inject constructor(
    private val propertyApi: PropertyApi,
    private val propertyDao: PropertyDao
): PropertyRepo {

    override suspend fun syncProperties() {

        val propertyResponse = propertyApi.getProperties()

        if (propertyResponse.isSuccessful) {
            println("API SUCCESS")
            propertyResponse.body()?.let { thePropertiesResponse ->
                println(thePropertiesResponse)
                val propertyEntities = thePropertiesResponse.properties.map {
                    PropertyEntity(
                        address = it.address,
                        photo = it.photos?.first() ?: Photo(""),
                        price = it.price
                    )
                }
                propertyDao.insertAll(
                    propertyEntities = propertyEntities
                )


            }
        } else {
            //error-handling or retry logic here
        }

    }

    override fun observeProperties(): Flow<List<PropertyEntity>> {
        return propertyDao.getAll()
    }

    override fun deleteAll() {
        propertyDao.deleteAll()
    }
}