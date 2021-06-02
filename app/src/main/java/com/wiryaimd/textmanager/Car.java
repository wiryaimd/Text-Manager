package com.wiryaimd.textmanager;

import javax.inject.Inject;

public class Car {

    private Engine engine;
    private Wheels wheels;

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

    public void drive(){
        System.out.println("drivingg bosss");
    }
}
