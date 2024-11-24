package com.example.book

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getAll(): Flow<List<Book>>
    @Query("SELECT * FROM books WHERE id = :id")
    suspend fun getById(id: Int): Book?

    @Insert
    suspend fun insert(book: Book)

    @Delete
    suspend fun delete(book: Book)



}