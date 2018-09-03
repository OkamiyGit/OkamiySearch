package com.okamiy.okamiysearch.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.okamiy.okamiysearch.BaseApplication;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 10:37
 * 一个工具类
 */
public class CommonUtil {

    /**
     * 获取Context
     *
     * @return
     */
    private static Context getContext() {
        return BaseApplication.getInstance();
    }

    /**
     * 颜色
     *
     * @param resId
     * @return
     */
    public static int getColor(int resId) {
        return ContextCompat.getColor(getContext(), resId);
    }

}
