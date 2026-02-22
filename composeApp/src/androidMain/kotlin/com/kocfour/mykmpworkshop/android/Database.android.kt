package com.kocfour.mykmpworkshop.android

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kocfour.mykmpworkshop.db.AppDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("water_tracker_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )//.addMigrations(Migration_1_2)
}