package com.okamiy.okamiysearch.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.okamiy.okamiysearch.R;
import com.okamiy.okamiysearch.activity.model.KeyWordsModel;
import com.okamiy.okamiysearch.activity.model.ResultModel;
import com.okamiy.okamiysearch.adapter.KeyWordsAdapter;
import com.okamiy.okamiysearch.adapter.SearchResultAdapter;
import com.okamiy.okamiysearch.global.Constant;
import com.okamiy.okamiysearch.utils.CommonUtil;
import com.okamiy.okamiysearch.utils.LoadingUtil;
import com.okamiy.okamiysearch.widget.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.droidlover.xrecyclerview.RecyclerItemCallback;
import cn.droidlover.xrecyclerview.XRecyclerView;

public class SearchActivity extends AppCompatActivity implements ISearch {
    private static final String TAG = "SearchActivity";

    @BindView(R.id.ed_search)
    AppCompatEditText mEdSearch;
    @BindView(R.id.iv_clear)
    ImageView mIvClear;
    @BindView(R.id.app_search_cancel)
    TextView mAppSearchCancel;
    @BindView(R.id.top_ll_parents)
    LinearLayout mTopLlParents;
    @BindView(R.id.tv_search_recorder)
    TextView mTvSearchRecorder;
    @BindView(R.id.iv_clear_history)
    ImageView mIvClearHistory;
    @BindView(R.id.frame_layer)
    FrameLayout mFrameLayer;
    @BindView(R.id.rl_history)
    RelativeLayout mRlHistory;
    @BindView(R.id.change_recycler)
    XRecyclerView mChangeRecycler;
    @BindView(R.id.empty_view)
    FrameLayout mEmpty;
    @BindView(R.id.ll_empty)
    LinearLayout mLlEmpty;
    @BindView(R.id.iv_empty)
    ImageView mIvEmpty;
    @BindView(R.id.tv_empty)
    TextView mTvEmpty;
    private SearchResultAdapter mAdapter;
    private KeyWordsAdapter mKeyAdapter;
    private InputMethodManager mSoftManager;
    private String content;
    private String keyContent;
    private PSearch mPressent;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        mHandler = new Handler(getMainLooper());
        mPressent = new PSearch(this, mHandler);
        setSearchListener();
        initRecycler();
        showHistory();
    }

    /**
     * 搜索监听
     */
    private void setSearchListener() {
        mSoftManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mEdSearch.setFocusable(true);
        mEdSearch.setFocusableInTouchMode(true);
        mEdSearch.requestFocus();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSoftManager.showSoftInput(mEdSearch, InputMethodManager.SHOW_FORCED);
            }
        }, 300);
        mEdSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "beforeTextChanged 打印：" + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged 打印: " + s);
                clearAdapterData();
                keyContent = s.toString().trim();
                if (before != 0 && count == 0 && s.length() == 0) {
                    showHistory();
                }
                if (!TextUtils.isEmpty(keyContent)) {
                    mIvClear.setVisibility(View.VISIBLE);
                    mEmpty.setVisibility(View.GONE);
                    showRecycler();
                    clearAdapterData();
                    mPressent.getKeyWdSearch(SearchActivity.this);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged 打印：" + s.toString());
            }
        });
        mEdSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    content = mEdSearch.getText().toString().trim();
                    if (TextUtils.isEmpty(content)) {
                        Toast.makeText(SearchActivity.this, R.string.empty_content, Toast.LENGTH_SHORT).show();
                    } else {
                        searchPoems(content);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * 执行搜索
     */
    private void searchPoems(String text) {
        mSoftManager.hideSoftInputFromWindow(mEdSearch.getWindowToken(), 0);
        clearAdapterData();
        showRecycler();
        if (!TextUtils.isEmpty(text)) {
            mPressent.saveHistoryData(text);
        }
        mPressent.getSearchResult();
    }


    /**
     * 清除数据
     */
    private void clearAdapterData() {
        if (null != mAdapter) {
            mAdapter.clearData();
        }
        if (null != mKeyAdapter) {
            mKeyAdapter.clearData();
        }
    }

    /**
     * 显示Adapter
     */
    private void showRecycler() {
        mRlHistory.setVisibility(View.GONE);
        mEmpty.setVisibility(View.GONE);
        mChangeRecycler.setVisibility(View.VISIBLE);
    }

    /**
     * 显示历史记录
     */
    private void showHistory() {
        mEmpty.setVisibility(View.GONE);
        mIvClear.setVisibility(View.GONE);
        mChangeRecycler.setVisibility(View.GONE);
        mIvClearHistory.setVisibility(View.VISIBLE);
        mRlHistory.setVisibility(View.VISIBLE);
        mFrameLayer.setVisibility(View.VISIBLE);
        mEdSearch.setText("");
        mEdSearch.setHint(R.string.search_hint);

        mPressent.getHistoryData();
    }

    /**
     * 初始化Recyclerview
     */
    private void initRecycler() {
        mChangeRecycler.verticalLayoutManager(this);
        if (mAdapter == null) {
            mAdapter = new SearchResultAdapter(this);
            mAdapter.setRecItemClick(new RecyclerItemCallback<ResultModel, SearchResultAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, ResultModel model, int tag, SearchResultAdapter.ViewHolder holder) {
                    if (Constant.ITEM_CLICK == tag) {
                        Toast.makeText(SearchActivity.this, model.getTitle() + model.getSort(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        if (mKeyAdapter == null) {
            mKeyAdapter = new KeyWordsAdapter(this);
            mKeyAdapter.setRecItemClick(new RecyclerItemCallback<KeyWordsModel, KeyWordsAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, KeyWordsModel model, int tag, KeyWordsAdapter.ViewHolder holder) {
                    if (Constant.ITEM_CLICK == tag) {
                        Toast.makeText(SearchActivity.this, model.getKeyWord() + " 执行搜索", Toast.LENGTH_LONG).show();
                        searchPoems("");
                    }
                }
            });
        }
    }

    @OnClick({R.id.iv_clear, R.id.app_search_cancel, R.id.iv_clear_history, R.id.empty_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //清除输入框的内容
            case R.id.iv_clear:
                showHistory();
                break;
            case R.id.app_search_cancel:
                finish();
                if (null != mSoftManager) {
                    mSoftManager.hideSoftInputFromWindow(mEdSearch.getWindowToken(), 0);
                }
                break;
            //清楚历史记录
            case R.id.iv_clear_history:
                LoadingUtil.show(this);
                mPressent.deleteHistoryData();
                break;
            //无网络刷新
            case R.id.empty_view:
                Toast.makeText(SearchActivity.this, "模拟刷新。。。", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

    /**
     * 显示加载框
     */
    @Override
    public void showLoading() {
        LoadingUtil.show(this);
    }

    /**
     * 隐藏加载框
     */
    @Override
    public void hideLoading() {
        LoadingUtil.close();
    }

    /**
     * 关键字结果展示
     *
     * @param mList 数据源
     */
    @Override
    public void showData(List<KeyWordsModel> mList) {
        mKeyAdapter.setData(mList);
        mChangeRecycler.setAdapter(mKeyAdapter);
    }

    /**
     * 显示历史记录
     *
     * @param historyData
     */
    @Override
    public void showHistoryData(ArrayList<String> historyData) {
        final FlowLayout flowLayout = new FlowLayout(this);
        int vPadding = 60;
        int hPadding = 32;
        //1.设置padding值
        int padding = 50;
        flowLayout.setPadding(padding, padding, padding, padding);
        //2.设置水平和垂直间距
        flowLayout.setHorizontalSpacing(padding);
        flowLayout.setVerticalSpacing(padding);
        mFrameLayer.removeAllViews();
        mFrameLayer.addView(flowLayout);
        for (final String historyString : historyData) {

            final TextView textView = new TextView(this);
            textView.setText(historyString);
            textView.setTextColor(CommonUtil.getColor(R.color.app_text_58_color));
            textView.setBackgroundResource(R.drawable.shape_rec_round_gray_search);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(13);
            textView.setPadding(vPadding, hPadding, vPadding, hPadding);
            flowLayout.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //次处是做点击搜索的，不做假数据了累啊
                }
            });
        }
    }

    /**
     * 隐藏历史记录布局
     */
    @Override
    public void hideHistoryView() {
        mChangeRecycler.setVisibility(View.GONE);
        mIvClearHistory.setVisibility(View.GONE);
        mFrameLayer.setVisibility(View.GONE);
    }

    /**
     * 展示空历史记录布局
     */
    @Override
    public void showEmpty() {
        mRlHistory.setVisibility(View.GONE);
        mEmpty.setVisibility(View.VISIBLE);
    }

    /**
     * 搜索结果展示
     *
     * @param mList
     */
    @Override
    public void showResultData(List<ResultModel> mList) {
        mAdapter.setData(mList);
        mChangeRecycler.setAdapter(mAdapter);
    }
}
