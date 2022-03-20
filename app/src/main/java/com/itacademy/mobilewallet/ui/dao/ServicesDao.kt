package com.itacademy.mobilewallet.ui.dao

import androidx.room.*
import com.itacademy.mobilewallet.ui.entities.Services

@Dao
interface ServicesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addServices(vararg services: Services)

    @Query("SELECT * FROM Services")
    fun getAllServices(): Array<Services>

    @Delete
    fun deleteServices(services: Services)
}