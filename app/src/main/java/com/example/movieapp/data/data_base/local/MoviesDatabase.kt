//package com.example.movieapp.data.data_base.local
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.movieapp.data.data_base.local.models.MovieInfoDataModelCache
//
//@Database(
//    entities = [
//        MovieInfoDataModelCache::class,
//    ],
//    version = 1,
//)
//
//abstract class MoviesDatabase : RoomDatabase() {
//    companion object {
//        @Volatile
//        private var INSTANCE: MoviesDatabase? = null
//        fun get(context: Context): MoviesDatabase {
//            if (INSTANCE == null) {
//                INSTANCE = Room.databaseBuilder(
//                    context, MoviesDatabase::class.java,
//                    "testBase"
//                ).build()
//            }
//            return INSTANCE as MoviesDatabase
//        }
//    }
//    abstract fun getMovieDao(): MoviesDAO
//}
////    companion object {
////        private var INSTANCE: TodoDatabase? = null
////        @Volatile
////        fun getDatabase(context: Context): TodoDatabase {
////            return INSTANCE ?: synchronized(this) {
////                val instance = Room.databaseBuilder(
////                    context.applicationContext,
////                    TodoDatabase::class.java,
////                    DATABASE_NAME
////                ).build()
////
////                INSTANCE = instance
////                instance
////            }
////        }
////    }