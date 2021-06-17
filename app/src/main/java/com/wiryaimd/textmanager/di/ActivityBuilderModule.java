package com.wiryaimd.textmanager.di;

import com.wiryaimd.textmanager.di.editing.EditingModule;
import com.wiryaimd.textmanager.di.editing.EditingScope;
import com.wiryaimd.textmanager.di.editing.dialog.DialogBuilderModule;
import com.wiryaimd.textmanager.di.main.MainScope;
import com.wiryaimd.textmanager.ui.editing.EditingActivity;
import com.wiryaimd.textmanager.ui.main.MainActivity;
import com.wiryaimd.textmanager.di.main.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @MainScope
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();

    @EditingScope
    @ContributesAndroidInjector(
            modules = {
                    EditingModule.class,
                    DialogBuilderModule.class
            }
    )
    abstract EditingActivity editingActivityd();

}
