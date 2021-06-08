package com.wiryaimd.textmanager.di.auth;

import com.wiryaimd.textmanager.network.auth.AuthApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    /**
     * deklarasi yekan hahay
     */
    @Provides
    static AuthApi providesAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }

}
