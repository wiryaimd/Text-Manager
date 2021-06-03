package com.wiryaimd.textmanager.dagger;

import com.wiryaimd.textmanager.car.WHahay;
import com.wiryaimd.textmanager.car.WKentot;
import com.wiryaimd.textmanager.car.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {

    @Provides
    static WKentot totKentot(){
        return new WKentot();
    }

    @Provides
    static WHahay totHahay(){
        WHahay wHahay = new WHahay();
        wHahay.asu();
        return wHahay;
    }

    @Provides
    static Wheels totCrotWheels(WKentot wKentot, WHahay wHahay){
        return new Wheels(wKentot, wHahay);
    }

}
