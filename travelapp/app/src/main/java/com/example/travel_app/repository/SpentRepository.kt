package com.example.travel_app.repository

import android.app.Application
import com.example.travel_app.dao.AppDatabaseConnection
import com.example.travel_app.dao.SpentDao
import com.example.travel_app.entity.Spent

class SpentRepository (app: Application) {

    private val spentDao: SpentDao

    init {
        spentDao = AppDatabaseConnection
            .getDB(app).spentDao()
    }

    suspend fun save(spent: Spent) {
        if (spent.id == 0) {
            spentDao.insert(spent)
        }
        else {
            spentDao.update(spent)
        }
    }

    suspend fun findAllByTravel(travelId: Int): List<Spent> = spentDao.findAllByTravel(travelId)

    suspend fun findById(id: Int) = spentDao.findById(id)

    suspend fun delete(spent: Spent) = spentDao.delete(spent)

}