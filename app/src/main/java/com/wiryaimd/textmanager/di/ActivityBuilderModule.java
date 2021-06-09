package com.wiryaimd.textmanager.di;

import com.wiryaimd.textmanager.di.auth.AuthModule;
import com.wiryaimd.textmanager.di.auth.AuthScope;
import com.wiryaimd.textmanager.di.auth.AuthViewModelModule;
import com.wiryaimd.textmanager.di.main.FragmentBuilderModule;
import com.wiryaimd.textmanager.di.main.MainModule;
import com.wiryaimd.textmanager.di.main.MainScope;
import com.wiryaimd.textmanager.ui.auth.AuthActivity;
import com.wiryaimd.textmanager.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    /**
     * ya kek nge provides sih ini anotasinya,
     * trus didalem nya ada modules untuk memasang AuthViewModelModule
     * berada di dalam scope authActivity
     */

    /**
     * anotasi authscope adalah sebagai grouping dari subcomponent(mainactivity, auth)
     * custom scope juga child dari singleton
     */
    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity authActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    FragmentBuilderModule.class,
                    MainModule.class
            }
    )
    abstract MainActivity mainActivity();

}
