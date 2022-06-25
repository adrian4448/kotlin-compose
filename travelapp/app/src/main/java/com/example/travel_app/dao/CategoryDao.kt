package com.example.travel_app.dao

import androidx.room.*
import com.example.travel_app.entity.Category
import com.example.travel_app.entity.Travel

@Dao
interface CategoryDao {

    @Insert()
    suspend fun insert(category: Category)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(category: Category)

    @Delete
    suspend fun delete(category: Category)

    @Query("select * from Category order by name")
    suspend fun findAll(): List<Category>

    @Query("select * from Category c where c.id = :id")
    suspend fun findById(id: Int): Category?

}