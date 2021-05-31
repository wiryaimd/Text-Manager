package com.wiryaimd.textmanager;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * membuat room database
 * tag @Database berisikan entitty/model/tabel dari documentdata
 *
 */
@Database(entities = {Documentdata.class}, version = 1, exportSchema = false)
public abstract class DocumentdataDatabase extends RoomDatabase {

    // instance boss
    private static DocumentdataDatabase instance;

    // digunakan untuk merubah data atau insert, update, dll
    public abstract DocumentdataDao documentdataDao();

    private static final int NUMBER_OF_THREADS = 5;
    public static ExecutorService asyncEx = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // biar singletod
    public static synchronized DocumentdataDatabase getInstance(Context context){
        if (instance == null){
            instance = Room
                    .databaseBuilder(context, DocumentdataDatabase.class, "textmanager_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(prepareData)
                    .build();

        }
        return instance;
    }


    /**
     * generate data saat instance pertama kali dibuat
     */

    private static RoomDatabase.Callback prepareData = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // mengguankan ExecutorServices
            asyncEx.execute(() -> {
                instance.documentdataDao().insert(new Documentdata("ngewe hayuu", "anjas guranjas takanjas anjas", "2021, 5, 31"));
                instance.documentdataDao().insert(new Documentdata("gile lu yak", "hahay papale", "2026, 4, 21"));
            });
        }
    };

    /**
     * menggunakan AsyncTask class
     */
//    private static class PrepareDataAsync extends AsyncTask<Void, Void, Void>{
//
//        private DocumentdataDatabase db;
//
//        public PrepareDataAsync(DocumentdataDatabase db) {
//            this.db = db;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            db.documentdataDao().insert(new Documentdata("ngewe hayuu", "anjas guranjas takanjas anjas", "2021, 5, 31"));
//            db.documentdataDao().insert(new Documentdata("gile lu yak", "hahay papale", "2026, 4, 21"));
//            return null;
//        }
//    }

}
