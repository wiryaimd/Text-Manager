package com.wiryaimd.textmanager.ui.editing;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.DataModel;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.DaggerActivity;

public class EditingActivity extends DaggerActivity {

    @Inject @Named("editingdata")
    DataModel dataModel;

    private EditText edtmain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        edtmain = findViewById(R.id.editing_edtmain);

        System.out.println(dataModel.test());

    }
}
