package com.example.travel_app.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.travel_app.entity.Category
import com.example.travel_app.entity.Spent
import com.example.travel_app.entity.Travel
import com.example.travel_app.entity.User

@Database(entities = arrayOf(User::class, Travel::class ,Spent::class ,Category::class), version = 5 )
abstract class AppDatabaseConnection: RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun travelDao(): TravelDao

    abstract fun categoryDao(): CategoryDao

    abstract fun spentDao(): SpentDao

    // Desing Pattern - Singleton
    companion object {
        var connection: AppDatabaseConnection? = null

        fun getDB(context: Context): AppDatabaseConnection {
            val temp = connection
            if (temp != null) {
                return temp
            }
            else {
                // conectar o banco
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabaseConnection::class.java,
                    "meu-database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                connection = instance
                return instance
            }
        }

    }
}