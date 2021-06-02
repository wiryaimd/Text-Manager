package com.wiryaimd.textmanager;

import dagger.Component;

/**
 * anotasi yang untuk menandakan komponen yang bisa di injek ke kelas lain
 * ini akan meng generate code sesuai method yg ada dalam interface
 */
@Component
public interface CarComponent {

    // tidak perlu dipakai lagi
    // karena sudah ada inject method
//    Car getCar();

    void inject(MainActivity mainActivity);

}
