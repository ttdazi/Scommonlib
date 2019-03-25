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

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (settings == null) settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getBoolean(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        if (settings == null) settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getInt(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static long getLong(Context context, String key, long defValue) {
        if (settings == null) settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getLong(key, defValue);
    }

    public static void putLong(Context context, String key, long value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defValue) {
        if (settings == null) settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getString(key, defValue);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void remove(Context context, String key) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.remove(key);
        editor.apply();
    }

}
