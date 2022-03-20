package com.itacademy.mobilewallet.ui.dao

import androidx.room.*
import com.itacademy.mobilewallet.ui.entities.Category

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCategory(vararg category: Category)

    @Query("SELECT * FROM Category")
    fun getAllCategory(): Array<Category>

    @Query("SELECT nameCategory FROM Category")
    fun getNameCategory(): List<String>

    @Delete
    fun deleteCategory(category: Category)
}