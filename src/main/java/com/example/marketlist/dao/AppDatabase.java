package com.example.marketlist.dao;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.marketlist.entity.Sobre;

@Database(entities = {Sobre.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


        private static AppDatabase appDatabase;

        public abstract SobreDAO createSobreDAO();

        public static AppDatabase getInstance(Context context) {
            if(appDatabase == null) {
                appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "driver_database")
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return appDatabase;
        }
    }

