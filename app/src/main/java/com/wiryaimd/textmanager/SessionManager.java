package com.wiryaimd.textmanager;

import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;

import com.wiryaimd.textmanager.customwidget.TmEditor;
import com.wiryaimd.textmanager.util.Measure;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {

    private static final String TAG = "SessionManager";

    private TmEditor tmEditor;
    private int linearMainX, linearMainY;

    @Inject
    public SessionManager(){

    }

    public void initTmEditor(TmEditor tmEditor){
        this.tmEditor = tmEditor;
    }

    public void initLayoutPosition(LinearLayout lmain, DisplayMetrics metrics){
        this.linearMainX = Measure.dpToPx(Measure.getPositionView(lmain).x, metrics);
        this.linearMainY = Measure.dpToPx(Measure.getPositionView(lmain).y, metrics);
    }

    public TmEditor getTmEditor(){
        return tmEditor;
    }

    public int getLinearMainX() {
        return linearMainX;
    }

    public int getLinearMainY() {
        return linearMainY;
    }

}
