package com.wiryaimd.textmanager.model.playeritem.materials;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class Iron implements Material{

    private static final String TAG = "Iron";

    private String role, cord;

    @Inject
    public Iron(@Named("role") String role, @Named("cord") String cord) {
        this.role = role;
        this.cord = cord;
    }

    @Override
    public void toolToTake() {
        Log.d(TAG, "toolToTake: Stone Pickaxe or higher " + role + " " + cord);
    }
}
