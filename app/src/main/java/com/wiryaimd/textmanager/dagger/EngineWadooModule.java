package com.wiryaimd.textmanager.dagger;

import com.wiryaimd.textmanager.car.Engine;
import com.wiryaimd.textmanager.car.EngineTod;
import com.wiryaimd.textmanager.car.EngineWadoo;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class EngineWadooModule {

    /**
     * anotasi binds digunakan untuk interface
     * interface engine akan mengambil data nya ke class EngineWadoo
     * kemudian me return nya menjadi engine
     */
    @Binds
    public abstract Engine engineWadoo(EngineWadoo engineWadoo);

}
