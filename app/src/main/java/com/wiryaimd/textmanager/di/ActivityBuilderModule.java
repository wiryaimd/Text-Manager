package com.wiryaimd.textmanager.di;

import com.wiryaimd.textmanager.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract AuthActivity authActivity();

}
