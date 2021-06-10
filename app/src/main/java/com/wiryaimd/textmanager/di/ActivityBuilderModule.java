package com.wiryaimd.textmanager.di;

import com.wiryaimd.textmanager.di.editing.EditingModule;
import com.wiryaimd.textmanager.ui.editing.EditingActivity;
import com.wiryaimd.textmanager.ui.main.MainActivity;
import com.wiryaimd.textmanager.di.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = {EditingModule.class})
    abstract EditingActivity editingActivityd();

}
