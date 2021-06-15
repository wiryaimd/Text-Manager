package com.wiryaimd.textmanager.di.main;

import com.wiryaimd.textmanager.models.DataModel;
import com.wiryaimd.textmanager.ui.main.DataAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    static DataAdapter dataAdapter(){
        return new DataAdapter();
    }
}
