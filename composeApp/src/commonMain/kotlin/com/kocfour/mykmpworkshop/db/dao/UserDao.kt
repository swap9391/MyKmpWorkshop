package com.kocfour.mykmpworkshop.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kocfour.mykmpworkshop.db.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    fun inset(userEntity: UserEntity)

    @Update
    fun update(userEntity: UserEntity)

    @Delete
    fun delete(userEntity: UserEntity)

    @Query("Select * from users")
    fun fetchUser(): UserEntity

}