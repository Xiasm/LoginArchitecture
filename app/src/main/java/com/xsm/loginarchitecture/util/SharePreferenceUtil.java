package com.xsm.loginarchitecture.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Author: 夏胜明
 * Date: 2018/8/14 0014
 * Email: xiasem@163.com
 * Description:
 */
public class SharePreferenceUtil {
    public static final String IS_LOGIN = "isLogin";

    public static boolean getBooleanSp(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);
    }

    public static void clearSharePref(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /* Boolean */
    public static void setBooleanSp(String key, Boolean value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

}
