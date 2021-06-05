package com.wiryaimd.textmanager;

import com.wiryaimd.textmanager.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * base application ykl
 * sebagai base dari application / child nya appcomponent nya ... maybeee yee
 */
public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(BaseApplication.this).build();
    }

}
