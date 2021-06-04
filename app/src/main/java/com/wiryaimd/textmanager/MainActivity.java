package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wiryaimd.textmanager.car.Car;
import com.wiryaimd.textmanager.car.Engine;
import com.wiryaimd.textmanager.dagger.CarComponent;
import com.wiryaimd.textmanager.dagger.DaggerCarComponent;
import com.wiryaimd.textmanager.dagger.EngineTodModule;
import com.wiryaimd.textmanager.dagger.WheelsModule;

import java.util.concurrent.Executors;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // anotasi inject agar tanpa menginisalisasi/tanpa menggunakan getCar()
    @Inject
    Car car;

    // ex 2
    // menginisialisasi kelas engine
//    @Inject
//    Engine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DaggerCarComponent merupakan generated class saat di compile
        // akan meng generate dagger class sesuai method yang ada di interface CarComponent
        CarComponent carComponent = DaggerCarComponent
                .builder()
                .h
                .build();

        // meberitahu untuk meng inject/menginisialisasi field pada kelas main activity
        carComponent.inject(MainActivity.this);

        // ex jika tidak menggunakan inject ke kelas(MainActivity)
        // Car car = carComponent.getCar();

//        engine.ngentod();
        car.drive();

    }
}