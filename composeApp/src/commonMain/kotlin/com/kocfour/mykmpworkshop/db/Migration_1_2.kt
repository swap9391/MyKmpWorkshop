package com.kocfour.mykmpworkshop.db

import androidx.room.migration.Migration
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL

/*

object Migration_1_2 : Migration(startVersion = 1, endVersion = 2){
    override fun migrate(connection: SQLiteConnection) {
        // when additional column being added
        connection.execSQL(
            """
            ALTER TABLE users
            ADD COLUMN age INTEGER NOT NULL DEFAULT 0
            """.trimIndent()
        )



        //**********************Rename column*********************************

        // 1. Create new table
        connection.execSQL(
            """
            CREATE TABLE users_new (
                id INTEGER PRIMARY KEY NOT NULL,
                full_name TEXT NOT NULL
            )
            """.trimIndent()
        )

        // 2. Copy data
        connection.execSQL(
            """
            INSERT INTO users_new (id, full_name)
            SELECT id, name FROM users
            """.trimIndent()
        )
        //**********************Rename column*********************************


        //Drop table
        connection.execSQL("DROP TABLE users")

        //Rename table name
        connection.execSQL("ALTER TABLE users_new RENAME TO users")

        //
    }
}*/