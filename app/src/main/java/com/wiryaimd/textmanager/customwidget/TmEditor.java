package com.wiryaimd.textmanager.customwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.Locale;

import javax.inject.Inject;

public class TmEditor extends AppCompatEditText {

    private Rect rect;
    private Paint paint;

    public TmEditor(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        rect = new Rect();
        paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int baseLine = getBaseline();
        for (int i = 0; i < getLineCount(); i++) {
            canvas.drawText(String.format(Locale.getDefault(),
                    "%" + spaceSize(i + 1) + "s |", i + 1), rect.left, baseLine + 5, paint);
            baseLine += getLineHeight();
        }
        super.onDraw(canvas);
    }

    public int spaceSize(int i){
        return 7 - String.valueOf(i).length() - 1;
    }
}
