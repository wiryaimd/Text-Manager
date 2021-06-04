package com.wiryaimd.textmanager.model.playeritem;

import android.util.Log;

import javax.inject.Inject;

public class Sword {

    private static final String TAG = "Sword";

    @Inject
    public Sword() {
    }
    
    public void use(){
        Log.d(TAG, "use: sword used");
    }
}
