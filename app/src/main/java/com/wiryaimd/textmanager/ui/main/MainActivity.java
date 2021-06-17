package com.wiryaimd.textmanager.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.db.models.DataModel;
import com.wiryaimd.textmanager.ui.editing.EditingActivity;
import com.wiryaimd.textmanager.ui.main.adapter.CategoryAdapter;
import com.wiryaimd.textmanager.ui.main.adapter.DataAdapter;
import com.wiryaimd.textmanager.vmprovider.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject DataAdapter dataAdapter;
    @Inject CategoryAdapter categoryAdapter;

    @Inject LinearLayoutManager linearLayoutManager;
    @Inject ViewModelProviderFactory providerFactory;

    private MainViewModel mainViewModel;

    private RecyclerView recyclerViewMain;

    private LinearLayout lcreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.main_recyclerview);
        lcreate = findViewById(R.id.main_lcreate);

        mainViewModel = new ViewModelProvider(MainActivity.this, providerFactory).get(MainViewModel.class);

        recyclerViewMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerViewMain.setAdapter(dataAdapter);

        mainViewModel.getAllData().observe(MainActivity.this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModels) {
                for (DataModel dataModel : dataModels){
                    Log.d(TAG, "onChanged: id: " + dataModel.getId());
                    Log.d(TAG, "onChanged: title: " + dataModel.getTitle());
                    Log.d(TAG, "onChanged: text: " + dataModel.getText());
                }
            }
        });

//        mainViewModel.insertData(new DataModel("yayaya", "hahay papalem pal wuhuu", "gileee", "gassda"));

        lcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditingActivity.class));
            }
        });
    }
}