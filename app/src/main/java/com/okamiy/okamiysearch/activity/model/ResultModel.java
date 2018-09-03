package com.okamiy.okamiysearch.activity.model;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 13:51
 */
public class ResultModel {
    private String title;
    private String sort;
    private String range;
    private int img;

    public ResultModel(String title, String sort, String range, int img) {
        this.title = title;
        this.sort = sort;
        this.range = range;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
