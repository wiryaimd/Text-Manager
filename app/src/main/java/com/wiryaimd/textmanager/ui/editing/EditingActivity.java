package com.wiryaimd.textmanager.ui.editing;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.customwidget.TmEditor;
import com.wiryaimd.textmanager.models.DataModel;
import com.wiryaimd.textmanager.ui.editing.dialog.FindDialog;
import com.wiryaimd.textmanager.util.Constants;
import com.wiryaimd.textmanager.util.Measure;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

public class EditingActivity extends DaggerAppCompatActivity {

    private static final String TAG = "EditingActivity";

    @Inject @Named("editingdata")
    DataModel dataModel;

    private TmEditor edtmain;
    private LinearLayout lmain, lcopy, lfind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        edtmain = findViewById(R.id.editing_edtmain);
        lmain = findViewById(R.id.editing_hlinearmain);
        lcopy = findViewById(R.id.editing_lcopy);
        lfind = findViewById(R.id.editing_lfind);

        lcopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: click copy " + dataModel.test());
            }
        });

        lfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics metrics = getResources().getDisplayMetrics();
                new FindDialog(EditingActivity.this, edtmain, Measure.dpToPx(Measure.getPositionView(lmain).x, metrics), Measure.dpToPx(Measure.getPositionView(lmain).y, metrics))
                        .show(getSupportFragmentManager(), Constants.DIALOG_TAG_FIND);
            }
        });

        System.out.println(dataModel.test());

    }
}
