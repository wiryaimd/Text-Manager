package com.wiryaimd.textmanager.ui.editing.dialog;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.util.DialogPosition;

import javax.inject.Inject;

import dagger.android.support.DaggerDialogFragment;

public class FindDialog extends DaggerDialogFragment {

    private static final String TAG = "FindDialog";

    @Inject Application application;
    @Inject SessionManager sessionManager;

    private EditText edtFind;
    private Button btnNext;

    private int posCursor = 0;

    private SpannableStringBuilder ssb;
    private BackgroundColorSpan bcs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog() != null) {
            DialogPosition.setupPosition(getDialog(), sessionManager);
        }
        return inflater.inflate(R.layout.dialog_findtext, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        edtFind = view.findViewById(R.id.findtext_edtmain);
        btnNext = view.findViewById(R.id.findtext_btnnext);

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
                }else{
                    ssb.removeSpan(bcs);
                    sessionManager.getTmEditor().setText(ssb);
                }
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
