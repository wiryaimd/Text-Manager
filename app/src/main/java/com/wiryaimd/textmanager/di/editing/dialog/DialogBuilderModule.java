package com.wiryaimd.textmanager.di.editing.dialog;

import com.wiryaimd.textmanager.ui.editing.dialog.FindDialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DialogBuilderModule {

    @ContributesAndroidInjector
    abstract FindDialog findDialog();
}
