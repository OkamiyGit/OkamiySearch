package com.okamiy.okamiysearch.activity.model;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 13:50
 */
public class KeyWordsModel {
    public KeyWordsModel(String keyWord) {
        this.keyWord = keyWord;
    }

    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
