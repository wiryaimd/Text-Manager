package com.wiryaimd.textmanager.car;

import android.util.Log;

import javax.inject.Inject;

public class EngineTod implements Engine {

    private static final String TAG = "EngineTod";

    /**
     * meng inject agar tau yekan
     */
    @Inject
    public EngineTod(){

    }

    /**
     * method dari interface engine yang akan bisa dipanggil di car class
     */
    @Override
    public void aghhh() {
        Log.d(TAG, "aghhh: anjaiiii");
    }
}
