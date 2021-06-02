package com.wiryaimd.textmanager;

import javax.inject.Inject;

public class Engine {

    /**
     * menghubungkan ke kelas Car
     * dimana class engine ini dipanggil melalui car
     * dan di inisialisasi di generated class (DaggerCarComponent)
     */
    @Inject
    public Engine(){

    }

    public void ngentod(){
        System.out.println("hehe boi anjeng");
    }

}
