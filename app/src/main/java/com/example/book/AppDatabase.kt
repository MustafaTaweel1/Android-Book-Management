package com.example.book



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Book::class], version = 2, exportSchema = false)

abstract class AppDatabase: RoomDatabase(
) {
    abstract fun bookDao(): BookDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: Room.databaseBuilder(context, AppDatabase::class.java, "BookDB")
//                    .build().also { INSTANCE = it }
//            }
//        }
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "book_database"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }

}