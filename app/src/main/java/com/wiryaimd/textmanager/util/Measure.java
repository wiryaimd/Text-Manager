package com.wiryaimd.textmanager.util;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class Measure {

    private static final String TAG = "Wiryaimd Measure: ";

    public static int dpToPx(float valDp, DisplayMetrics display){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valDp, display);
    }

    public static int pxToDp(float valPx, DisplayMetrics display){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, valPx, display);
    }

    public static Point getPositionView(View view){
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Point(location[0], location[1]);
    }

}
