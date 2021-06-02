package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DaggerCarComponent merupakan generated class saat di compile
        // akan meng generate dagger class sesuai method yang ada di interface CarComponent
        CarComponent carComponent = DaggerCarComponent.create();

        Car car = carComponent.getCar();
        car.drive();

    }
}