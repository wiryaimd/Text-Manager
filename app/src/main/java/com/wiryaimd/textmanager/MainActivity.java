package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import retrofit2.Retrofit;

/**
 * boilerplate = kode yang dapat digunakan berulang-ulang tanpa perubahan
 *
 * mirip template tapi
 * boilerplate != template
 *
 * boilerplate untuk menghemat waktu early development
 *
 */

public class MainActivity extends AppCompatActivity {

    /**
     * MVVM architecture jrod
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int cek = 1;
    }
}