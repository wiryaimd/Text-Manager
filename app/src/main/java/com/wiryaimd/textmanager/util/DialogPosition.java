package com.wiryaimd.textmanager.util;

import android.app.Dialog;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wiryaimd.textmanager.SessionManager;

public class DialogPosition {

    private static final String TAG = "DialogPosition";

    public static void setupPosition(Dialog dialog, SessionManager sessionManager){
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setGravity(Gravity.END);
        // menghilangkan dim (background nya dialog)
        dialog.getWindow().setDimAmount(0);

        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        // layoutparam.y = 0
        // posisi 0 ada di start nya di tengah
        layoutParams.y = layoutParams.y - sessionManager.getLinearMainY();
        Log.d(TAG, "onCreateView: linearY: " + layoutParams.y + "   " + sessionManager.getLinearMainY());

        dialog.getWindow().setAttributes(layoutParams);
    }

}
