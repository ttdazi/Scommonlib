package com.aidazi.scommonlib.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.aidazi.scommonlib.log.SLog;

/**
 * author: Y_Qing
 * date: 2019/2/14
 */
public class ScreenUtils {

    public static int getSceenHeight(Context activity) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(localDisplayMetrics);
        SLog.i("getSceenHeight", localDisplayMetrics.density + "..." + localDisplayMetrics.densityDpi);
        return localDisplayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context activity) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.widthPixels;
    }
}
