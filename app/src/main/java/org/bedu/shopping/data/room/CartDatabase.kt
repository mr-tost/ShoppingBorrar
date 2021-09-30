package com.example.beducompras.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.bedu.shopping.data.model.Product

@Database(entities = arrayOf(Product::class), version = 1, exportSchema = false)
abstract class ShopDatabase: RoomDatabase(){

    abstract fun cartDao(): CartDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.

        private const val DB_NAME = "shop_database"

        @Volatile
        private var INSTANCE: ShopDatabase? = null

        fun getDatabase(context: Context): ShopDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShopDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}