package com.wiryaimd.textmanager.ui.editing;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.customwidget.TmEditor;
import com.wiryaimd.textmanager.models.DataModel;
import com.wiryaimd.textmanager.ui.editing.dialog.FindDialog;
import com.wiryaimd.textmanager.ui.editing.dialog.ReplaceDialog;
import com.wiryaimd.textmanager.util.Constants;
import com.wiryaimd.textmanager.util.Measure;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.DaggerActivity;
import dagger.android.support.DaggerAppCompatActivity;

public class EditingActivity extends DaggerAppCompatActivity {

    private static final String TAG = "EditingActivity";

    @Inject SessionManager sessionManager;
    @Inject ClipboardManager clipboardManager;

    private TmEditor edtmain;
    private LinearLayout lmain, lcopy, lpaste, lselectall, lfind, lreplace, ltab, lduplicate;

    private RelativeLayout rlmain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        edtmain = findViewById(R.id.editing_edtmain);
        rlmain = findViewById(R.id.editing_rlmain);

        lmain = findViewById(R.id.editing_hlinearmain);
        lcopy = findViewById(R.id.editing_lcopy);
        lpaste = findViewById(R.id.editing_lpaste);
        lselectall = findViewById(R.id.editing_lselectall);
        lfind = findViewById(R.id.editing_lfind);
        lreplace = findViewById(R.id.editing_lreplace);
        ltab = findViewById(R.id.editing_ltab);
        lduplicate = findViewById(R.id.editing_lduplicate);

        // TODO copy all text
        lcopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtmain.getText() != null) {
                    ClipData clipData = ClipData.newPlainText("CopyTmEditor", edtmain.getText().toString());
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(EditingActivity.this, "Copied All Text", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EditingActivity.this, "Failed To Copy Text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TODO paste text
        lpaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clipboardManager.hasPrimaryClip()){
                    ClipData.Item item = clipboardManager.getPrimaryClip().getItemAt(0);
                    edtmain.setText(item.getText().toString());
                    Toast.makeText(EditingActivity.this, "Pasted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EditingActivity.this, "Failed To Paste Text", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TODO select all text
        lselectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtmain.selectAll();
            }
        });

        // TODO find word/text in edittext
        lfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.initEditingActivity(edtmain, lmain, getResources().getDisplayMetrics());
                new FindDialog().show(getSupportFragmentManager(), Constants.DIALOG_TAG_FIND);
            }
        });

        // TODO replace text from-to
        lreplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.initEditingActivity(edtmain, lmain, getResources().getDisplayMetrics());
                new ReplaceDialog().show(getSupportFragmentManager(), Constants.DIALOG_TAG_REPLACE);
            }
        });

        // TODO add tab to edittext
        ltab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtmain.getText() != null) {
                    int selectionCursor = edtmain.getSelectionStart();
                    StringBuilder sb = new StringBuilder(edtmain.getText().toString());
                    sb.insert(selectionCursor, "    ");
                    edtmain.setText(sb.toString());
                    edtmain.setSelection(selectionCursor + 4);
                }
            }
        });

        // TODO duplicate text
        lduplicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtmain.hasSelection() && edtmain.getText() != null) {
                    StringBuilder sb = new StringBuilder(edtmain.getText().toString());
                    sb.insert(edtmain.getSelectionEnd(), sb.substring(edtmain.getSelectionStart(), edtmain.getSelectionEnd()));
                    edtmain.setText(sb.toString());
                }else{
                    Toast.makeText(EditingActivity.this, "Please select text to duplicate", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
