package com.wiryaimd.textmanager.model.playeritem.materials;

import android.util.Log;

import javax.inject.Inject;

public class Wood implements Material{

    private static final String TAG = "Wood";

    @Inject
    public Wood() {
    }

    @Override
    public void toolToTake() {
        Log.d(TAG, "toolToTake: Wooden Axe or higher ");
    }
}
