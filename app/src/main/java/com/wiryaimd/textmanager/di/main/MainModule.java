package com.wiryaimd.textmanager.di.main;

import android.app.Application;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.wiryaimd.textmanager.ui.main.adapter.CategoryAdapter;
import com.wiryaimd.textmanager.ui.main.adapter.DataAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    static DataAdapter dataAdapter(){
        return new DataAdapter();
    }

    @Provides
    static CategoryAdapter categoryAdapter(){
        return new CategoryAdapter();
    }

    @Provides
    static LinearLayoutManager linearLayoutManager(Application application){
        return new LinearLayoutManager(application);
    }
}
