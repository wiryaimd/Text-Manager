package com.wiryaimd.textmanager.di;

import android.app.Application;

import com.wiryaimd.textmanager.BaseApplication;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {AndroidInjectionModule.class, ActivityBuilderModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder ngews(@Named("ngews") String ngews);

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
