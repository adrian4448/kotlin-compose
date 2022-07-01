package com.example.travel_app.dao

import androidx.room.*
import com.example.travel_app.entity.Spent

@Dao
interface SpentDao {

    @Insert()
    suspend fun insert(spent: Spent)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(spent: Spent)

    @Delete
    suspend fun delete(spent: Spent)

    @Query("select * from Spent order by description")
    suspend fun findAll(): List<Spent>

    @Query("select * from Spent s where s.id = :id")
    suspend fun findById(id: Int): Spent?

}