package com.example.travel_app.repository

import android.app.Application
import com.example.travel_app.dao.AppDatabaseConnection
import com.example.travel_app.dao.UserDao
import com.example.travel_app.entity.User

class UserRepository (app: Application) {

    private val userDao: UserDao

    init {
        userDao = AppDatabaseConnection
            .getDB(app).userDao()
    }

    suspend fun save(user: User) {
        if (user.id == 0) {
            userDao.insert(user)
        }
        else {
            userDao.update(user)
        }
    }

    suspend fun findAll(): List<User> = userDao.findAll()

    suspend fun findById(id: Int) = userDao.findById(id)

    suspend fun delete(user: User) = userDao.delete(user)

    suspend fun findUserByUsernameAndPassword(userName: String, password: String) =
        userDao.findUserByUsernameAndPassword(userName, password)

}