package com.wiryaimd.textmanager.ui.editing.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.util.DialogPosition;

import javax.inject.Inject;

import dagger.android.support.DaggerDialogFragment;

public class ReplaceDialog extends DaggerDialogFragment {

    @Inject SessionManager sessionManager;

    private EditText edtfrom, edtto;
    private Button btnnext, btnreplace;

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

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnreplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
