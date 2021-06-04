package com.wiryaimd.textmanager.model.playeritem.materials;

import android.util.Log;

import javax.inject.Inject;

public class Iron implements Material{

    private static final String TAG = "Iron";

    @Inject
    public Iron() {
    }

    @Override
    public void toolToTake() {
        Log.d(TAG, "toolToTake: Stone Pickaxe or higher");
    }
}
