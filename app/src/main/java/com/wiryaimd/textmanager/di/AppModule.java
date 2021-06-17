package com.wiryaimd.textmanager.di;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wiryaimd.textmanager.db.TmRepository;
import com.wiryaimd.textmanager.vmprovider.ViewModelProviderFactory;

import java.util.Map;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static ViewModelProvider.Factory providerFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap){
        return new ViewModelProviderFactory(providerMap);
    }

    @Singleton
    @Provides
    static TmRepository tmRepository(Application application){
        return new TmRepository(application);
    }

}
