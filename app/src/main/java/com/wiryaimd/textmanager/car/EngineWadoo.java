package com.wiryaimd.textmanager.car;

import android.util.Log;

import javax.inject.Inject;

/**
 * sama kek EngineTod class
 */
public class EngineWadoo implements Engine {

    private static final String TAG = "EngineWadoo";

    @Inject
    public EngineWadoo(){

    }
    
    @Override
    public void aghhh() {
        Log.d(TAG, "aghhh: kyaaaa entod");
    }
}
