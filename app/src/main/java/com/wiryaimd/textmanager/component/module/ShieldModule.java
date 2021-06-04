package com.wiryaimd.textmanager.component.module;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public class ShieldModule {

    private static final String TAG = "ShieldModule";

    @Provides
    public int combining(){
        Log.d(TAG, "combining: fixing shield");
        return 1;
    }

}
