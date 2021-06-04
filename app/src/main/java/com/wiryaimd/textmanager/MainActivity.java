package com.wiryaimd.textmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wiryaimd.textmanager.component.DaggerWtfComponent;
import com.wiryaimd.textmanager.component.WtfComponent;
import com.wiryaimd.textmanager.model.Player;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WtfComponent wtfComponent = DaggerWtfComponent.create();
        wtfComponent.mainActivity(MainActivity.this);

        player.attack();

    }
}