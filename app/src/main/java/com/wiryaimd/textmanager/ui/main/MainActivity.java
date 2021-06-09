package com.wiryaimd.textmanager.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.DataModel;
import com.wiryaimd.textmanager.ui.Ph;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

public class MainActivity extends DaggerActivity {

    @Inject
    DataAdapter adapter;

    @Inject
    DataModel dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}