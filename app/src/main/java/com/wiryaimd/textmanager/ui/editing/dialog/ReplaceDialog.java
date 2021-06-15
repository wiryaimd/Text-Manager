package com.wiryaimd.textmanager.ui.editing.dialog;

import android.app.Application;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.util.DialogPosition;

import javax.inject.Inject;

import dagger.android.support.DaggerDialogFragment;

public class ReplaceDialog extends DaggerDialogFragment {

    private static final String TAG = "ReplaceDialog";

    @Inject SessionManager sessionManager;
    @Inject Application application;

    private EditText edtfrom, edtto;
    private Button btnnext, btnreplace, btnreplaceall;
    
    private int posCursor = 0;

    private SpannableStringBuilder ssb;
    private BackgroundColorSpan bcs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog() != null){
            DialogPosition.setupPosition(getDialog(), sessionManager);
        }
        return inflater.inflate(R.layout.dialog_replacetext, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        edtfrom = view.findViewById(R.id.replacetext_edtfrom);
        edtto = view.findViewById(R.id.replacetext_edtto);
        btnnext = view.findViewById(R.id.replacetext_btnnext);
        btnreplace = view.findViewById(R.id.replacetext_btnreplace);
        btnreplaceall = view.findViewById(R.id.replacetext_btnreplaceall);

        ssb = new SpannableStringBuilder(sessionManager.getTmEditor().getText());
        bcs = new BackgroundColorSpan(Color.parseColor("#ffc107"));

        initEdt();

        View.OnClickListener btnnextClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sessionManager.getTmEditor() != null && isContainsEdt()) {
                    posCursor = getWordPos(posCursor + 1);
                    if (posCursor == -1) {
                        posCursor = getWordPos(0);
                    }
                    ssb.setSpan(bcs, posCursor, posCursor + edtfrom.getText().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    sessionManager.getTmEditor().setText(ssb);
                    sessionManager.getTmEditor().setSelection(posCursor);
                }
            }
        };
        btnnext.setOnClickListener(btnnextClick);

        btnreplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sessionManager.getTmEditor().getText() != null && isContainsEdt()){
                    if (!edtto.getText().toString().isEmpty()) {
                        ssb.replace(posCursor, posCursor + edtfrom.getText().length(), edtto.getText().toString());
                        sessionManager.getTmEditor().setText(ssb);
                        btnnextClick.onClick(v);
                    }else{
                        Toast.makeText(application, "Input Text To", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(application, "Text From not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnreplaceall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sessionManager.getTmEditor().getText() != null && isContainsEdt()){
                    if (!edtto.getText().toString().isEmpty()) {
                        try {
                            ssb = ssb.replace(0, ssb.length(), ssb.toString().replaceAll(edtfrom.getText().toString(), edtto.getText().toString()));
                            sessionManager.getTmEditor().setText(ssb);
                        }catch (IllegalArgumentException e) {
                            Toast.makeText(application, "Failed to Replace all", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(application, "Input Text To", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        
    }
    
    public void initEdt(){
        edtfrom.addTextChangedListener(new TextWatcher() {
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
                        ssb.setSpan(bcs, posCursor, posCursor + edtfrom.getText().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
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
        return sessionManager.getTmEditor().getText().toString().toLowerCase().contains(edtfrom.getText().toString().toLowerCase());
    }

    public int getWordPos(int from){
        return sessionManager.getTmEditor().getText().toString().toLowerCase().indexOf(edtfrom.getText().toString().toLowerCase(), from);
    }
}
