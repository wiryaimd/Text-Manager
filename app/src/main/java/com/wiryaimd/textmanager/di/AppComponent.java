package com.wiryaimd.textmanager.di;

import android.app.Application;
import android.graphics.Paint;
import android.graphics.Rect;

import com.wiryaimd.textmanager.BaseApplication;
import com.wiryaimd.textmanager.SessionManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityBuilderModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    SessionManager sessionManager();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
