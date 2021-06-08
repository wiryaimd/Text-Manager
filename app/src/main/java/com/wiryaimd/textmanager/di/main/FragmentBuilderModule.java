package com.wiryaimd.textmanager.di.main;

import com.wiryaimd.textmanager.ui.main.posts.PostsFragment;
import com.wiryaimd.textmanager.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(
            modules = FragmentMapModule.class
    )
    abstract ProfileFragment profileFragment();

    @ContributesAndroidInjector(
            modules = FragmentMapModule.class
    )
    abstract PostsFragment postsFragment();

}
