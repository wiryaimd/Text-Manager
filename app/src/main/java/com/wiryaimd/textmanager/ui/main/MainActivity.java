package com.wiryaimd.textmanager.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.DataModel;
import com.wiryaimd.textmanager.ui.Ph;
import com.wiryaimd.textmanager.ui.editing.EditingActivity;

import javax.inject.Inject;

import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    DataAdapter adapter;

    private Button btncreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncreate = findViewById(R.id.main_btncreate);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditingActivity.class));
            }
        });
    }
}