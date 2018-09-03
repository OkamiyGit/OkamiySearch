package com.okamiy.okamiysearch.utils;

import com.okamiy.okamiysearch.BaseApplication;
import com.okamiy.okamiysearch.global.Constant;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 11:11
 * SP缓存
 */
public class SpUtils {

    /**
     * 取出搜索历史记录
     */
    public static String getPoemSearchData() {
        return SharedPref.getInstance(BaseApplication.getInstance())
                .getString(Constant.POEMS_SEARCH_DATA, "");
    }

    /**
     * 存入搜索历史记录
     *
     * @param searchData
     */
    public static void putPoemSearchData(String searchData) {
        SharedPref.getInstance(BaseApplication.getInstance())
                .putString(Constant.POEMS_SEARCH_DATA, searchData);
    }

}
