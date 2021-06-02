package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // anotasi inject agar tanpa menginisalisasi/tanpa menggunakan getCar()
    @Inject Car car;

    // ex 2
    @Inject
    Engine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DaggerCarComponent merupakan generated class saat di compile
        // akan meng generate dagger class sesuai method yang ada di interface CarComponent
        CarComponent carComponent = DaggerCarComponent.create();

        // meberitahu untuk meng inject/menginisialisasi field pada kelas main activity
        carComponent.inject(MainActivity.this);

        // ex jika tidak menggunakan inject ke kelas(MainActivity)
        // Car car = carComponent.getCar();

        engine.ngentod();
        car.drive();

    }
}