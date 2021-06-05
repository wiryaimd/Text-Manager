package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.wiryaimd.textmanager.component.DaggerWtfComponent;
import com.wiryaimd.textmanager.component.WtfComponent;
import com.wiryaimd.textmanager.component.module.ShieldModule;
import com.wiryaimd.textmanager.component.module.ShieldModule_CombiningFactory;
import com.wiryaimd.textmanager.model.Player;
import com.wiryaimd.textmanager.model.playeritem.Sword;
import com.wiryaimd.textmanager.model.playeritem.materials.Iron;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject Player player;

    @Inject
    Sword sword;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // singleton save model if screen rotated
        WtfComponent wtfComponent = ((MyApplication) getApplication()).getWtfComponent();
        wtfComponent.mainActivity(MainActivity.this);

        Log.d(TAG, "onCreate: " + sword);

        player.attack();

    }
}