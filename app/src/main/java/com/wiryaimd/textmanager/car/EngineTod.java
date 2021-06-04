package com.wiryaimd.textmanager.car;

import android.util.Log;

import javax.inject.Inject;

public class EngineTod implements Engine {

    private static final String TAG = "EngineTod";

    private int value_bossku;

    /**
     * meng inject agar tau yekan
     */
    @Inject
    public EngineTod(int value_bossku) {
        this.value_bossku = value_bossku;
    }

    /**
     * method dari interface engine yang akan bisa dipanggil di car class
     */
    @Override
    public void aghhh() {
        Log.d(TAG, "aghhh: anjaiiii " + value_bossku);
    }
}
