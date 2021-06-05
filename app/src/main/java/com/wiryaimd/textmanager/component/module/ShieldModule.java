package com.wiryaimd.textmanager.component.module;

import android.opengl.Matrix;
import android.util.Log;

import com.wiryaimd.textmanager.model.playeritem.materials.Iron;
import com.wiryaimd.textmanager.model.playeritem.materials.Material;
import com.wiryaimd.textmanager.model.playeritem.materials.Wood;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public class ShieldModule {

    private static final String TAG = "ShieldModule";

    /**
     * untuk meng inisialisasikan saja sih intinya
     * dengan return type yang di inginkan dan type yang mau di inisialisasikan
     */
    @Provides
    public Material combining(Iron iron){
        Log.d(TAG, "combining: fixing shield");
        return iron;
    }

}
