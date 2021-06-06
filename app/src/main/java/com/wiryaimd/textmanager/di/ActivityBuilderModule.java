package com.wiryaimd.textmanager.di;

import com.wiryaimd.textmanager.di.auth.AuthModule;
import com.wiryaimd.textmanager.di.auth.AuthViewModelModule;
import com.wiryaimd.textmanager.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    /**
     * ya kek nge provides sih ini anotasinya,
     * trus didalem nya ada modules untuk memasang AuthViewModelModule
     * berada di dalam scope authActivity
     */
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity authActivity();

}
