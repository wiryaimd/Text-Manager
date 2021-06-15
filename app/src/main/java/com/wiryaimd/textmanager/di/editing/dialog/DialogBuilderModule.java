package com.wiryaimd.textmanager.di.editing.dialog;

import com.wiryaimd.textmanager.ui.editing.dialog.EditTitleDialog;
import com.wiryaimd.textmanager.ui.editing.dialog.FindDialog;
import com.wiryaimd.textmanager.ui.editing.dialog.ReplaceDialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DialogBuilderModule {

    @ContributesAndroidInjector
    abstract FindDialog findDialog();

    @ContributesAndroidInjector
    abstract ReplaceDialog replaceDialog();

    @ContributesAndroidInjector
    abstract EditTitleDialog editTitleDialog();
}
