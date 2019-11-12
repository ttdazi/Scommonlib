package com.aidazi.scommonlib.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * author: Y_Qing
 * date: 2019/2/14
 */
public class SPUtils {
    static SharedPreferences settings;
    private static String spName = null;
    private static String keySub = "";

    public SPUtils() {
    }

    public static void setSpName(String spName, String keySub) {
        SPUtils.spName = spName;
        SPUtils.keySub = keySub;
    }

    public static void getSp(Context context) {
        if (settings == null) {
            if (spName != null) {
                settings = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
            } else {
                settings = PreferenceManager.getDefaultSharedPreferences(context);
            }
        }

    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        getSp(context);
        key = keySub + key;
        return settings.getBoolean(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        getSp(context);
        SharedPreferences.Editor editor = settings.edit();
        key = keySub + key;
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        getSp(context);
        key = keySub + key;
        return settings.getInt(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        getSp(context);
        SharedPreferences.Editor editor = settings.edit();
        key = keySub + key;
        editor.putInt(key, value);
        editor.apply();
    }

    public static long getLong(Context context, String key, long defValue) {
        getSp(context);
        key = keySub + key;
        return settings.getLong(key, defValue);
    }

    public static void putLong(Context context, String key, long value) {
        getSp(context);
        SharedPreferences.Editor editor = settings.edit();
        key = keySub + key;
        editor.putLong(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defValue) {
        getSp(context);
        key = keySub + key;
        return settings.getString(key, defValue);
    }

    public static void putString(Context context, String key, String value) {
        getSp(context);
        SharedPreferences.Editor editor = settings.edit();
        key = keySub + key;
        editor.putString(key, value);
        editor.apply();
    }

    public static void remove(Context context, String key) {
        getSp(context);
        SharedPreferences.Editor editor = settings.edit();
        key = key + keySub;
        editor.remove(key);
        editor.apply();
    }

}
