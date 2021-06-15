package com.wiryaimd.textmanager.ui.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.customwidget.TmEditor;
import com.wiryaimd.textmanager.ui.editing.dialog.EditTitleDialog;
import com.wiryaimd.textmanager.ui.editing.dialog.FindDialog;
import com.wiryaimd.textmanager.ui.editing.dialog.ReplaceDialog;
import com.wiryaimd.textmanager.util.Constants;
import com.wiryaimd.textmanager.util.EdtHistory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class EditingActivity extends DaggerAppCompatActivity {

    private static final String TAG = "EditingActivity";

    @Inject SessionManager sessionManager;
    @Inject ClipboardManager clipboardManager;
    @Inject EdtHistory edtHistory;

    private Toolbar toolbar;

    private TmEditor edtmain;
    private LinearLayout lmain, lcopy, lpaste, lselectall, lfind, lreplace, ltab, lduplicate;

    private RelativeLayout rlmain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        // TODO menetapkan posisi layout ketika keyboard muncul
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        toolbar = findViewById(R.id.editing_toolbar);
        setSupportActionBar(toolbar);

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

        // TODO save edtmain to sessionManager
        sessionManager.initTmEditor(edtmain);

        // TODO setup edtHistory after initTmEditor
        edtHistory.initEdtHistory();

        // TODO on navigation click, edit text title name
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EditTitleDialog().show(getSupportFragmentManager(), Constants.DIALOG_TAG_EDITTITLE);
            }
        });

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
                    if (edtmain.getText() == null){
                        edtmain.setText(item.getText().toString());
                        Toast.makeText(EditingActivity.this, "Pasted", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuilder sb = new StringBuilder(edtmain.getText().toString());
                    int startCursor = edtmain.getSelectionStart();
                    sb.insert(startCursor, item.getText().toString());
                    edtmain.setText(sb.toString());
                    edtmain.setSelection(startCursor + item.getText().length());
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
                sessionManager.initLayoutPosition(lmain, getResources().getDisplayMetrics());
                new FindDialog().show(getSupportFragmentManager(), Constants.DIALOG_TAG_FIND);
            }
        });

        // TODO replace text from-to
        lreplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.initLayoutPosition(lmain, getResources().getDisplayMetrics());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editing_maintool, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.editingmenu_save:
                Log.d(TAG, "onOptionsItemSelected: menu save");
                return true;
            case R.id.editingmenu_undo:
                if (edtHistory.getEdtMain() != null){
                    edtHistory.undo();
                }
                return true;
            case R.id.editingmenu_redo:
                if (edtHistory.getEdtMain() != null){
                    edtHistory.redo();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
