package com.wiryaimd.textmanager.di.auth;

import com.wiryaimd.textmanager.models.UserModel;
import com.wiryaimd.textmanager.network.auth.AuthApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    /**
     * deklarasi yekan hahay
     *
     * dan authscope adalah custom scope yang dibuat seperti singleton
     */
    @AuthScope
    @Provides
    static AuthApi providesAuthApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }

    /**
     * anotasi @Named untuk memberi id dan bisa digunakan untuk return class yang sama
     * pada provides anno
     */
    @Provides
    @Named("gileee")
    static UserModel userModel(){
        return new UserModel();
    }

}
