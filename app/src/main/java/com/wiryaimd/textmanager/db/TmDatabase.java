package com.wiryaimd.textmanager.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.wiryaimd.textmanager.db.dao.DataDao;
import com.wiryaimd.textmanager.db.models.DataModel;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DataModel.class}, version = 1, exportSchema = false)
public abstract class TmDatabase extends RoomDatabase {

    private static TmDatabase instance;
    public static final ExecutorService asyncExecutor = Executors.newFixedThreadPool(5);

    public abstract DataDao getDataDao();

    public static synchronized TmDatabase getInstance(Application application){
        if (instance == null){
            instance = Room
                    .databaseBuilder(application, TmDatabase.class, "tm_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
