package com.wiryaimd.textmanager.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.wiryaimd.textmanager.viewmodels.ViewModelProviderFactory;

import java.util.Map;

import javax.inject.Provider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModelFactoryModule {

    /**
     * anotasi binds gunanya sama kaya provides
     * cuman ini dipake buat method abstract aja ye
     */
//    @Binds
//    abstract ViewModelProvider.Factory viewModelProviderFactory(ViewModelProviderFactory providerFactory);


    /**
     * kita juga bisa menggunakan method yang ini
     * fungsinya sama kek diatas
     */

    /**
     * buat deklarasi vmproviderfactory
     * di parameter nya itu (yang map) didapat/dibuat dari method provides authviewmodelmodule
     * yang berisikan @IntoMap, sesuai dengan kegunaanya
     */
    @Provides
    static ViewModelProviderFactory bisaJugaPakeIni(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap){
        return new ViewModelProviderFactory(providerMap);
    }




}
