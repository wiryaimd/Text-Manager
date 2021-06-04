package com.wiryaimd.textmanager.component.module;

import android.opengl.Matrix;
import android.util.Log;

import com.wiryaimd.textmanager.model.playeritem.materials.Iron;
import com.wiryaimd.textmanager.model.playeritem.materials.Material;
import com.wiryaimd.textmanager.model.playeritem.materials.Wood;

import dagger.Module;
import dagger.Provides;

@Module
public class ShieldModule {

    private static final String TAG = "ShieldModule";

    @Provides
    public Material combining(Iron iron){
        Log.d(TAG, "combining: fixing shield");
        return iron;
    }

}
