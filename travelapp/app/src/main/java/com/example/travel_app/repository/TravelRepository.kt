package com.example.travel_app.repository

import android.app.Application
import com.example.travel_app.dao.AppDatabaseConnection
import com.example.travel_app.dao.TravelDao
import com.example.travel_app.entity.Travel

class TravelRepository (app: Application) {

    private val travelDao: TravelDao

    init {
        travelDao = AppDatabaseConnection
            .getDB(app).travelDao()
    }

    suspend fun save(travel: Travel) {
        if (travel.id == 0) {
            travelDao.insert(travel)
        }
        else {
            travelDao.update(travel)
        }
    }

    suspend fun findAll(): List<Travel> = travelDao.findAll()

    suspend fun findById(id: Int) = travelDao.findById(id)

    suspend fun delete(travel: Travel) = travelDao.delete(travel)

}