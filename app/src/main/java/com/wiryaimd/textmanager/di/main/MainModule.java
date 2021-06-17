package com.wiryaimd.textmanager.di.main;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.wiryaimd.textmanager.di.ViewModelType;
import com.wiryaimd.textmanager.ui.main.MainViewModel;
import com.wiryaimd.textmanager.ui.main.adapter.CategoryAdapter;
import com.wiryaimd.textmanager.ui.main.adapter.DataAdapter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelType(MainViewModel.class)
    abstract ViewModel mainViewModel(MainViewModel mainViewModel);

    @MainScope
    @Provides
    static DataAdapter dataAdapter(){
        return new DataAdapter();
    }

    @MainScope
    @Provides
    static CategoryAdapter categoryAdapter(){
        return new CategoryAdapter();
    }

    @MainScope
    @Provides
    static LinearLayoutManager linearLayoutManager(Application application){
        return new LinearLayoutManager(application);
    }
}
