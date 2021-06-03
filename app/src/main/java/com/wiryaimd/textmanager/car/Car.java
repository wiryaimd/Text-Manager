package com.wiryaimd.textmanager.car;

import javax.inject.Inject;

public class Car {

//    /**
//     * ini adalah field yang digunakan untuk inisialisai
//     * sama seperti inject field di mainactivity
//     */
    private Wheels wheels;
    private Engine engine;

    /**
     * anotasi inject pada constructor untuk
     * menghubungkan kelas ini ke interface component
     * sehingga saling terhubung
     */
    @Inject
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    /**
     * bisa inject method yekan
     * parameter nya yang akan di inisialisasi ... maybe
     */
    @Inject
    public void ewebang(Remote remote){
        remote.ngontol();
    }

    public void drive(){

        // bisa dipanggil yekan sesuai module yang dipasang pada component class
        engine.aghhh();


        System.out.println("drivingg bosss");
    }
}
