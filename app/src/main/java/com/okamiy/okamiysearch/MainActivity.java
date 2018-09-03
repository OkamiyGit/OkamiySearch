package com.okamiy.okamiysearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.okamiy.okamiysearch.activity.SearchActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 跳转搜索界面
     */
    @OnClick({R.id.tv_search})
    public void searchStart() {
        startActivity(new Intent(this, SearchActivity.class));
    }
}
