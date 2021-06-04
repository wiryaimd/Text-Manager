package com.wiryaimd.textmanager.car;

import android.util.Log;

import javax.inject.Inject;

import dagger.Provides;

/**
 * sama kek EngineTod class
 */
public class EngineWadoo implements Engine {

    private static final String TAG = "EngineWadoo";

    int yaya;

    @Inject
    public EngineWadoo(int yaya) {
        this.yaya = yaya;
    }

    @Override
    public void aghhh() {
        Log.d(TAG, "aghhh: kyaaaa entod");
    }


}
