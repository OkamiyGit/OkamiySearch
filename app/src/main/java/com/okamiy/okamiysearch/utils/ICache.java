package com.okamiy.okamiysearch.utils;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 11:14
 */
public interface ICache {
    void put(String key, Object value);

    Object get(String key);

    void remove(String key);

    boolean contains(String key);

    void clear();
}
