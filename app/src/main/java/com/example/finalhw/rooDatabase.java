package com.example.finalhw;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {roo.class},version=1,exportSchema = false)
public abstract class rooDatabase extends RoomDatabase {
    private static  rooDatabase INSTANCE;
    static rooDatabase getDatabase(Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),rooDatabase.class,"roo_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public abstract rooDao getrooDao();
}
