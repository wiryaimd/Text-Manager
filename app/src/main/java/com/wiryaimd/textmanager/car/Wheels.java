package com.wiryaimd.textmanager.car;

import javax.inject.Inject;

public class Wheels {

    private WKentot wKentot;
    private WHahay wHahay;

    /**
     * menghubungkan ke kelas Car
     * dimana class wheels ini dipanggil melalui car
     * dan di inisialisasi di generated class (DaggerCarComponent)
     */
    @Inject
    public Wheels(WKentot wKentot, WHahay wHahay){
        this.wKentot = wKentot;
        this.wHahay = wHahay;
    }

    public void entodakudog(){
        System.out.println("hehe sa ae lu tai kont");
    }

}
