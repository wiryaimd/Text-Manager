package com.wiryaimd.textmanager.di;

import android.app.Application;

import com.wiryaimd.textmanager.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
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

/**
 * jadi singletod itu bisa dibilang juga dengan Scope
 * tiap module yang memiliki scope yang sama dengan komponennya yaitu singleton
 * maka dia akan termasuk ke skope nya
 *
 * kita juga bisa membuat custom scope untuk modul2 atau activity kita
 */

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class,
                ViewModelFactoryModule.class
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
