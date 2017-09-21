package com.viacheslavtitov.commoncode.ui;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Viacheslav Titov on 21.09.2017.
 */

public class DimensUtils {

    public static int convertDpToPixels(float dp, Context context) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        return px;
    }

    public static int convertSpToPixels(float sp, Context context) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
        return px;
    }

}
