package com.itacademy.mobilewallet.ui.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itacademy.mobilewallet.ui.dao.CategoryDao
import com.itacademy.mobilewallet.ui.dao.PaymentsDao
import com.itacademy.mobilewallet.ui.dao.ServicesDao
import com.itacademy.mobilewallet.ui.entities.*

@Database(entities = [Services::class, Category::class, Payments::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CategoryDao(): CategoryDao
    abstract fun ServicesDao(): ServicesDao
    abstract fun PaymentsDao(): PaymentsDao
}