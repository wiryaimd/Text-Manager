package com.wiryaimd.textmanager.model.playeritem;

import android.util.Log;

import javax.inject.Inject;

public class Shield {

    private static final String TAG = "Shield";

    @Inject
    public Shield() {
    }
    
    public void defend(){
        Log.d(TAG, "defend: defending");
    }
}
