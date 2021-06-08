package com.wiryaimd.textmanager.di.main;

import com.wiryaimd.textmanager.network.main.MainApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static MainApi mainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

}
