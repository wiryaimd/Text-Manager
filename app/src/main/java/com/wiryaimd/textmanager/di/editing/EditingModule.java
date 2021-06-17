package com.wiryaimd.textmanager.di.editing;

import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.di.ViewModelType;
import com.wiryaimd.textmanager.ui.editing.EditingViewModel;
import com.wiryaimd.textmanager.util.EdtHistory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class EditingModule {

    @Binds
    @IntoMap
    @ViewModelType(EditingViewModel.class)
    abstract ViewModel editingViewModel(EditingViewModel editingViewModel);

    @EditingScope
    @Provides
    static EdtHistory edtHistory(SessionManager sessionManager){
        return new EdtHistory(sessionManager);
    }

    @EditingScope
    @Provides
    static ClipboardManager clipboardManager(Application application){
        return (ClipboardManager) application.getSystemService(Context.CLIPBOARD_SERVICE);
    }
}
