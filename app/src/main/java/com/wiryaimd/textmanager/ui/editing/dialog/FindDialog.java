package com.wiryaimd.textmanager.ui.editing.dialog;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.customwidget.TmEditor;
import com.wiryaimd.textmanager.models.DataModel;
import com.wiryaimd.textmanager.util.Measure;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.DaggerDialogFragment;

public class FindDialog extends DaggerDialogFragment {

    private static final String TAG = "FindDialog";

    private EditText edtFind;
    private Button btnNext;

    private View snackbar;
    
    private int posCursor = 0;

    @Inject
    @Named("editingdata")
    DataModel dataModel;

    @Inject
    Application application;

    @Inject
    SessionManager sessionManager;

    private SpannableStringBuilder ssb;
    private BackgroundColorSpan bcs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog() != null && getActivity() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setGravity(Gravity.END);
            // menghilangkan dim (background nya dialog)
            getDialog().getWindow().setDimAmount(0);

            WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            // layoutparam.y = 0
            // posisi 0 ada di start nya di tengah
            layoutParams.y = layoutParams.y - sessionManager.getLinearMainY();
            Log.d(TAG, "onCreateView: linearY: " + layoutParams.y + "   " + sessionManager.getLinearMainY());

            getDialog().getWindow().setAttributes(layoutParams);

        }
        return inflater.inflate(R.layout.dialog_findtext, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        edtFind = view.findViewById(R.id.findtext_edtmain);
        btnNext = view.findViewById(R.id.findtext_btnnext);
        snackbar = view.findViewById(android.R.id.content);

        ssb = new SpannableStringBuilder(sessionManager.getTmEditor().getText());
        bcs = new BackgroundColorSpan(Color.parseColor("#ffc107"));

//        setupFocus();
        initEdt();
        
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sessionManager.getTmEditor() != null && isContainsEdt()) {
                    posCursor = getWordPos(posCursor + 1);
                    if (posCursor == -1) {
                        posCursor = getWordPos(0);
                    }
                    ssb.setSpan(bcs, posCursor, posCursor + edtFind.getText().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    sessionManager.getTmEditor().setText(ssb);
                    sessionManager.getTmEditor().setSelection(posCursor);
                }
            }
        });
    }

    // request focus & open keyboard automatically
    public void setupFocus(){
        edtFind.requestFocus();
        InputMethodManager imm = (InputMethodManager) application.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void initEdt(){

        edtFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (sessionManager.getTmEditor().getText() != null
                        && sessionManager.getTmEditor().getText().length() >= s.length()
                        && isContainsEdt()){

                    posCursor = getWordPos(0);

                    if (posCursor != -1){
                        ssb.setSpan(bcs, posCursor, posCursor + edtFind.getText().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                        sessionManager.getTmEditor().setText(ssb);
                        sessionManager.getTmEditor().setSelection(posCursor);
                    }

                    Log.d(TAG, "onTextChanged: tmEditor: " + sessionManager.getTmEditor().getText().toString());
                    Log.d(TAG, "onTextChanged: cs: " + s.toString());
                }
                Log.d(TAG, "onTextChanged: change");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);

        ssb.removeSpan(bcs);
        sessionManager.getTmEditor().setText(ssb);
    }
    
    public boolean isContainsEdt(){
        return sessionManager.getTmEditor().getText().toString().toLowerCase().contains(edtFind.getText().toString().toLowerCase());
    }
    
    public int getWordPos(int from){
        return sessionManager.getTmEditor().getText().toString().toLowerCase().indexOf(edtFind.getText().toString().toLowerCase(), from);
    }
}
