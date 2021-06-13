package com.wiryaimd.textmanager.ui.editing.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.DataModel;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.DaggerDialogFragment;

public class FindDialog extends DaggerDialogFragment {

    private static final String TAG = "FindDialog";

    private EditText edtFind;

    @Inject
    @Named("editingdata")
    DataModel dataModel;

    private int lmainX, lmainY;

    public FindDialog(int lmainX, int lmainY) {
        this.lmainX = lmainX;
        this.lmainY = lmainY;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog() != null) {
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

        Log.d(TAG, "onViewCreated: datamodel: " + dataModel.test());

        edtFind = view.findViewById(R.id.findtext_edtmain);

        edtFind.requestFocus();

    }
}
