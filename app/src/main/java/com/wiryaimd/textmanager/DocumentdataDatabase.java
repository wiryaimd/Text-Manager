package com.wiryaimd.textmanager;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * membuat database ... maybe
 * tag @Database berisikan entitty/model dari documentdata
 *
 */
@Database(entities = {Documentdata.class}, version = 1)
public abstract class DocumentdataDatabase extends RoomDatabase {

    // instance boss
    private static DocumentdataDatabase instance;

    // digunakan untuk merubah data atau insert, update, dll
    public abstract DocumentdataDao documentdataDao();

    // biar singletod
    public static synchronized DocumentdataDatabase getInstance(Context context){
        if (instance == null){
            instance = Room
                    .databaseBuilder(context, DocumentdataDatabase.class, "textmanager_database")
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }

}
