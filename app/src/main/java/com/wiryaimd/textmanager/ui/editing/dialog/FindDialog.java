package com.wiryaimd.textmanager.ui.editing.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wiryaimd.textmanager.R;
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

    @Inject
    @Named("editingdata")
    DataModel dataModel;

    private TmEditor tmEditor;
    private int lmainX, lmainY;

    private Activity activity;
    public FindDialog(Activity activity, TmEditor tmEditor, int lmainX, int lmainY) {
        this.activity = activity;
        this.tmEditor = tmEditor;
        this.lmainX = lmainX;
        this.lmainY = lmainY;
    }

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
            layoutParams.y = layoutParams.y - lmainY;

            getDialog().getWindow().setAttributes(layoutParams);

        }
        return inflater.inflate(R.layout.dialog_findtext, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        edtFind = view.findViewById(R.id.findtext_edtmain);

        setupFocus();

        initEdt();
    }

    // request focus & open keyboard automatically
    public void setupFocus(){
        edtFind.requestFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void initEdt(){
        List<Integer> posList = new ArrayList<>();

        edtFind.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (tmEditor.getText() != null && tmEditor.getText().length() > s.length()){
                    Log.d(TAG, "onTextChanged: tmEditor: " + tmEditor.getText().toString());
                    Log.d(TAG, "onTextChanged: s cs: " + s.toString());
                }
                Log.d(TAG, "onTextChanged: change");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
