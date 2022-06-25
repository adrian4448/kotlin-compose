package com.example.travel_app.repository

import android.app.Application
import com.example.travel_app.dao.AppDatabaseConnection
import com.example.travel_app.dao.CategoryDao
import com.example.travel_app.entity.Category

class CategoryRepository(app: Application) {

    private val categoryDao: CategoryDao

    init {
        categoryDao = AppDatabaseConnection
            .getDB(app).categoryDao()
    }

    suspend fun save(category: Category) {
        if (category.id == 0) {
            categoryDao.insert(category)
        }
        else {
            categoryDao.update(category)
        }
    }

    suspend fun findAll(): List<Category> = categoryDao.findAll()

    suspend fun findById(id: Int) = categoryDao.findById(id)

    suspend fun delete(category: Category) = categoryDao.delete(category)

}