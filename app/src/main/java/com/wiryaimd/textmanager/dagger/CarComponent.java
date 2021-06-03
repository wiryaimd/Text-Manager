package com.wiryaimd.textmanager.dagger;

import com.wiryaimd.textmanager.MainActivity;
import com.wiryaimd.textmanager.car.Car;

import dagger.Component;

/**
 * anotasi yang untuk menandakan komponen yang bisa di injek ke kelas lain
 * ini akan meng generate code sesuai method yg ada dalam interface
 */

@Component(modules = {WheelsModule.class, EngineTodModule.class})
public interface CarComponent {

    // tidak perlu dipakai lagi
    // karena sudah ada inject method
//    Car getCar();

    void inject(MainActivity mainActivity);

    void crot(Car car);

}
