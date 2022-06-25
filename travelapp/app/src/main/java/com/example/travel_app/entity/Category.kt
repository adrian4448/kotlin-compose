package com.example.travel_app.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category (
    val name: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}