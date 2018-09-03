package com.okamiy.okamiysearch;

import android.app.Application;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 10:39
 * Application
 */
public class BaseApplication extends Application {

    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
}
