package com.wiryaimd.textmanager.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.ui.editing.EditingActivity;
import com.wiryaimd.textmanager.ui.main.adapter.CategoryAdapter;
import com.wiryaimd.textmanager.ui.main.adapter.DataAdapter;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject DataAdapter dataAdapter;
    @Inject CategoryAdapter categoryAdapter;

    @Inject LinearLayoutManager linearLayoutManager;

    private RecyclerView recyclerViewMain, recyclerViewCategory;

    private LinearLayout lcreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMain = findViewById(R.id.main_recyclerview_list);
        recyclerViewCategory = findViewById(R.id.main_recyclerview_category);
        lcreate = findViewById(R.id.main_lcreate);

        recyclerViewMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.HORIZONTAL,
                false)
        );

        recyclerViewMain.setAdapter(dataAdapter);
        recyclerViewCategory.setAdapter(categoryAdapter);

        lcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditingActivity.class));
            }
        });
    }
}