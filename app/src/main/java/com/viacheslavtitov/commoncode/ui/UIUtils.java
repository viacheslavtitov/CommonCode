package com.viacheslavtitov.commoncode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Viacheslav Titov on 21.09.2017.
 */

public class UIUtils {

    /**
     * Show error in bottom Snackbar
     *
     * @param error
     * @param rootView
     * @return
     */
    public static Snackbar showError(String error, View rootView) {
        final String html = String.format("<font color=\"#faa800\">%s</font>", error);
        Snackbar snackbar = Snackbar.make(rootView, Html.fromHtml(html), Snackbar.LENGTH_LONG);
        snackbar.show();
        return snackbar;
    }

    public static void showKeyboard(Context context, View view) {
        final InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static Bitmap rotate(Bitmap bitmap, float degrees) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap flip(Bitmap bitmap, boolean horizontal, boolean vertical) {
        Matrix matrix = new Matrix();
        matrix.preScale(horizontal ? -1 : 1, vertical ? -1 : 1);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

}
