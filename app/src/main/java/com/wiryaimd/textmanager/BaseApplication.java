package com.wiryaimd.textmanager;

import android.graphics.Paint;
import android.graphics.Rect;

import com.wiryaimd.textmanager.di.AppComponent;
import com.wiryaimd.textmanager.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(BaseApplication.this).build();
    }

}
