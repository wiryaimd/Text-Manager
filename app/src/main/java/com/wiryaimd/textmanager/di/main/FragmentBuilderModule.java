package com.wiryaimd.textmanager.di.main;

import com.wiryaimd.textmanager.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(
            modules = FragmentProfileModule.class
    )
    abstract ProfileFragment profileFragment();

}
