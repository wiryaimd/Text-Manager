package com.wiryaimd.textmanager;

import android.app.Application;

import com.wiryaimd.textmanager.component.DaggerWtfComponent;
import com.wiryaimd.textmanager.component.WtfComponent;

public class MyApplication extends Application {

    private WtfComponent wtfComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        wtfComponent = DaggerWtfComponent.builder()
                .ongkeh("asu 1432")
                .hahay("anjai 6346436")
                .build();
    }

    public WtfComponent getWtfComponent() {
        return wtfComponent;
    }
}
