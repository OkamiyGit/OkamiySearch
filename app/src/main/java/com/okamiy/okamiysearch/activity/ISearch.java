package com.okamiy.okamiysearch.activity;

import com.okamiy.okamiysearch.activity.model.KeyWordsModel;
import com.okamiy.okamiysearch.activity.model.ResultModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 10:11
 * View层
 */
public interface ISearch {
    /**
     * 显示正在加载进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载进度框
     */
    void hideLoading();

    /**
     * 关键字搜索
     *
     * @param mList 数据源
     */
    void showData(List<KeyWordsModel> mList);

    /**
     * 显示历史记录
     *
     * @param searchArrayList
     */
    void showHistoryData(ArrayList<String> searchArrayList);

    /**
     * 隐藏历史记录相关
     */
    void hideHistoryView();

    /**
     * 显示历史记录空布局
     */
    void showEmpty();

    /**
     * 搜索结果
     *
     * @param mList
     */
    void showResultData(List<ResultModel> mList);
}
