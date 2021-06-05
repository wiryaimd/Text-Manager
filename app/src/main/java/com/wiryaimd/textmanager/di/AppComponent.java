package com.wiryaimd.textmanager.di;

import android.app.Application;
import android.content.Context;

import com.wiryaimd.textmanager.AuthActivity;
import com.wiryaimd.textmanager.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * component sebagai services nya dan base application sebagai client
 * begitupun dengan lainya
 * (component = parent, application = child )
 */

/**
 *  AppComponent sebagai parent yang akan berjalan selama aplikasi hidup
 *  berbda dengan AuthComponent/MainComponent yang berjalan saat (auth saat login)
 *  AuthComponent, MainComponent sebagai child nya AppComponent
 */
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class
        }
)

public interface AppComponent extends AndroidInjector<BaseApplication>{

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
