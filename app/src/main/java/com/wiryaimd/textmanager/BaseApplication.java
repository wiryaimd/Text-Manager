package com.wiryaimd.textmanager;

import com.wiryaimd.textmanager.di.AppComponent;
import com.wiryaimd.textmanager.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().ngews("wihihi").application(BaseApplication.this).build();
    }

}
