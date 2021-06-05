package com.wiryaimd.textmanager.model.playeritem;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * yaaa singletod lah kentod yow kentod lah
 */
@Singleton
public class Sword {

    private static final String TAG = "Sword";

    @Inject
    public Sword() {
    }
    
    public void use(){
        Log.d(TAG, "use: sword used");
    }
}
