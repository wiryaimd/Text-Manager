package com.wiryaimd.textmanager.dagger;

import com.wiryaimd.textmanager.car.Engine;
import com.wiryaimd.textmanager.car.EngineTod;
import com.wiryaimd.textmanager.car.Wheels;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class EngineTodModule {

    int value_bossku;

//    public EngineTodModule(int value_bossku) {
//        this.value_bossku = value_bossku;
//    }

    @Provides
    int getValue_bossku(){
        return value_bossku;
    }

    @Provides
    public Engine apaansi(EngineTod engineTod){
        return engineTod;
    }
    //    /**
//     * anotasi binds digunakan untuk interface
//     * interface engine akan mengambil data nya ke class EngineTod
//     * kemudian me return nya menjadi engine
//     */
//    @Binds
//    public abstract Engine anjaihehe(EngineTod engineTod);
//    // anotasi bind harus ber method abstract

}
