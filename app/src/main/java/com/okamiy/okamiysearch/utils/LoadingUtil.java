package com.okamiy.okamiysearch.utils;

import android.app.Dialog;
import android.content.Context;

import com.okamiy.okamiysearch.R;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 10:35
 * Loading加载框
 */
public class LoadingUtil {
    static Dialog dialog = null;

    /**
     * 显示Loading
     *
     * @param context
     */
    public static void show(Context context) {
        if (null != dialog) {
            dialog.dismiss();
        }
        dialog = new Dialog(context, R.style.my_dialog);
        dialog.setContentView(R.layout.view_loading);
        // 设置点击Dialog外部任意区域不能关闭Dialog
        dialog.setCanceledOnTouchOutside(false);
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    /**
     * 关闭Loading
     */
    public static void close() {
        if (null != dialog) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
