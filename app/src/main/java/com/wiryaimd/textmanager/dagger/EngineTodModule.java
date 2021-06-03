package com.wiryaimd.textmanager.dagger;

import com.wiryaimd.textmanager.car.Engine;
import com.wiryaimd.textmanager.car.EngineTod;
import com.wiryaimd.textmanager.car.Wheels;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class EngineTodModule {

    /**
     * anotasi binds digunakan untuk interface
     * interface engine akan mengambil data nya ke class EngineTod
     * kemudian me return nya menjadi engine
     */
    @Binds
    public abstract Engine anjaihehe(EngineTod engineTod);

}
