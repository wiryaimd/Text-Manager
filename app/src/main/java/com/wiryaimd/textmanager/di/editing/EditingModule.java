package com.wiryaimd.textmanager.di.editing;

import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;

import com.wiryaimd.textmanager.models.DataModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class EditingModule {

    @Provides
    @Named("editingdata")
    DataModel dataModel(@Named("ngews") String nge){
        return new DataModel(nge);
    }

    @Provides
    ClipboardManager clipboardManager(Application application){
        return (ClipboardManager) application.getSystemService(Context.CLIPBOARD_SERVICE);
    }
}
