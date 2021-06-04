package com.wiryaimd.textmanager.dagger;

import com.wiryaimd.textmanager.car.WHahay;
import com.wiryaimd.textmanager.car.WKentot;
import com.wiryaimd.textmanager.car.Wheels;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {

    private int hehe;

    @Inject
    public WheelsModule(int kucinggarox){
        this.hehe = kucinggarox;
    }

    @Provides
    WKentot totKentot(){
        System.out.println("bjirrr: " + hehe);
        return new WKentot();
    }

    @Provides
    WHahay totHahay(){
        WHahay wHahay = new WHahay();
        wHahay.asu();
        return wHahay;
    }

    @Provides
    Wheels totCrotWheels(WKentot wKentot, WHahay wHahay){
        return new Wheels(wKentot, wHahay);
    }

}
