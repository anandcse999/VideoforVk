package akhmedoff.usman.data.db

import akhmedoff.usman.data.model.*
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(
        entities = [Owner::class, Video::class, Album::class, Catalog::class, CatalogItem::class],
        version = 10,
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        fun getInstance(context: Context) = Room
                .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "vt_database.db"
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun albumDao(): AlbumDao

    abstract fun ownerDao(): OwnerDao

    abstract fun catalogDao(): CatalogDao

    abstract fun videoDao(): VideoDao
}