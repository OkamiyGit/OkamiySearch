package com.okamiy.okamiysearch.activity;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.okamiy.okamiysearch.R;
import com.okamiy.okamiysearch.activity.model.KeyWordsModel;
import com.okamiy.okamiysearch.activity.model.ResultModel;
import com.okamiy.okamiysearch.activity.model.SearchModel;
import com.okamiy.okamiysearch.utils.SpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 10:13
 * P层
 */
public class PSearch {
    private final ArrayList<ResultModel> mList;
    // View接口
    private ISearch mView;
    private Gson gson;
    private Handler mHandler;

    public PSearch(ISearch view, Handler handler) {
        this.mHandler = handler;
        this.mView = view;
        mList = new ArrayList<>();
        ResultModel model01 = new ResultModel("Okamiy", "火影忍者", "20~30", R.drawable.img_001);
        ResultModel model02 = new ResultModel("包容天下", "海贼王", "10~30", R.drawable.img_002);
        ResultModel model03 = new ResultModel("Okamiy", "妖精的尾巴", "22~32", R.drawable.img_003);
        ResultModel model04 = new ResultModel("今天的阳光", "西游记", "20~30", R.drawable.img_004);
        ResultModel model05 = new ResultModel("包容天下", "水浒传", "2~10", R.drawable.img_005);
        ResultModel model06 = new ResultModel("今天的阳光", "人名的名义", "26~30", R.drawable.img_006);
        ResultModel model07 = new ResultModel("今生缘来生续", "红楼梦", "21~30", R.drawable.img_009);
        ResultModel model08 = new ResultModel("Okamiy", "西游记", "20~31", R.drawable.img_007);
        ResultModel model09 = new ResultModel("包容天下", "火影忍者", "60~70", R.drawable.img_008);
        ResultModel model10 = new ResultModel("Okamiy", "海贼王", "20~30", R.drawable.img_010);
        ResultModel model12 = new ResultModel("今天的阳光", "海贼王", "20~30", R.drawable.img_011);
        ResultModel model13 = new ResultModel("世界之窗", "西游记", "10~310", R.drawable.img_011);
        ResultModel model14 = new ResultModel("三生三世", "西游记", "210~30", R.drawable.img_012);
        ResultModel model15 = new ResultModel("三生三世", "火影忍者", "206~360", R.drawable.img_013);
        ResultModel model16 = new ResultModel("Okamiy", "海贼王", "26~30", R.drawable.img_014);
        ResultModel model17 = new ResultModel("今生缘来生续", "红楼梦", "20~30", R.drawable.img_015);
        ResultModel model18 = new ResultModel("Okamiy", "火影忍者", "22~30", R.drawable.img_016);
        ResultModel model19 = new ResultModel("Okamiy", "红楼梦", "20~30", R.drawable.img_017);
        ResultModel model20 = new ResultModel("今天的阳光", "西游记", "20~30", R.drawable.img_018);
        ResultModel model21 = new ResultModel("Okamiy", "火影忍者", "40~30", R.drawable.img_019);
        ResultModel model22 = new ResultModel("包容天下", "红楼梦", "20~30", R.drawable.img_020);
        ResultModel model23 = new ResultModel("Okamiy", "火影忍者", "45~690", R.drawable.img_021);
        ResultModel model24 = new ResultModel("三生三世", "海贼王", "20~30", R.drawable.img_022);
        ResultModel model25 = new ResultModel("今天的阳光", "西游记", "2~30", R.drawable.img_023);
        ResultModel model26 = new ResultModel("Okamiy", "火影忍者", "20~30", R.drawable.img_024);
        ResultModel model27 = new ResultModel("Okamiy", "海贼王", "27~30", R.drawable.img_025);
        ResultModel model28 = new ResultModel("世界之窗", "海贼王", "20~30", R.drawable.img_026);
        ResultModel model29 = new ResultModel("世界之窗", "火影忍者", "2~34", R.drawable.img_027);
        ResultModel model30 = new ResultModel("世界之窗", "平凡的世界", "20~30", R.drawable.img_028);
        ResultModel model31 = new ResultModel("三生三世", "火影忍者", "20~30", R.drawable.img_029);
        ResultModel model32 = new ResultModel("Okamiy", "西游记", "2~30", R.drawable.img_016);
        ResultModel model33 = new ResultModel("世界之窗", "西游记", "14~30", R.drawable.img_020);
        ResultModel model34 = new ResultModel("三生三世", "平凡的世界", "20~30", R.drawable.img_029);
        ResultModel model35 = new ResultModel("Okamiy", "火影忍者", "20~30", R.drawable.img_014);
        ResultModel model36 = new ResultModel("今生缘来生续", "平凡的世界", "24~30", R.drawable.img_006);
        ResultModel model37 = new ResultModel("三生三世", "四季如春", "20~34", R.drawable.img_021);
        ResultModel model38 = new ResultModel("今生缘来生续", "平凡的世界", "20~40", R.drawable.img_008);
        ResultModel model39 = new ResultModel("Okamiy", "海棠花", "2~12", R.drawable.img_014);
        ResultModel model40 = new ResultModel("今生缘来生续", "超能勇士", "4~30", R.drawable.img_001);
        ResultModel model41 = new ResultModel("今生缘来生续", "火影忍者", "90~96", R.drawable.img_021);
        mList.add(model01);
        mList.add(model02);
        mList.add(model03);
        mList.add(model04);
        mList.add(model05);
        mList.add(model06);
        mList.add(model07);
        mList.add(model08);
        mList.add(model09);
        mList.add(model10);
        mList.add(model12);
        mList.add(model13);
        mList.add(model14);
        mList.add(model15);
        mList.add(model16);
        mList.add(model17);
        mList.add(model18);
        mList.add(model19);
        mList.add(model20);
        mList.add(model21);
        mList.add(model22);
        mList.add(model23);
        mList.add(model24);
        mList.add(model25);
        mList.add(model26);
        mList.add(model27);
        mList.add(model28);
        mList.add(model29);
        mList.add(model30);
        mList.add(model31);
        mList.add(model32);
        mList.add(model33);
        mList.add(model34);
        mList.add(model35);
        mList.add(model36);
        mList.add(model37);
        mList.add(model38);
        mList.add(model39);
        mList.add(model40);
        mList.add(model41);
        mList.add(model25);
        mList.add(model37);
        mList.add(model01);
        mList.add(model06);
        mList.add(model16);
        mList.add(model19);
        mList.add(model22);
        mList.add(model25);
        mList.add(model27);
    }

    /**
     * 关键字搜索
     * 此处数据造假：你们可以从服务器拉取数据
     */
    public void getKeyWdSearch(final Context context) {
        mView.showLoading();
        //模拟延迟
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String[] strs = context.getResources().getStringArray(R.array.str_list);
                //随机索引
                int id = (int) (Math.random() * (strs.length - 1));
                KeyWordsModel model = new KeyWordsModel(strs[id]);
                List<KeyWordsModel> mList = new ArrayList<>();
                mList.add(model);
                mView.hideLoading();
                mView.showData(mList);
            }
        }, 1600);

    }

    /**
     * 结果搜索
     */
    public void getSearchResult() {
        mView.showLoading();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int num = random.nextInt(44);
                int num1 = random.nextInt(44);
                int num2 = random.nextInt(44);
                List<ResultModel> models = new ArrayList<>();
                models.add(mList.get(num));
                models.add(mList.get(num1));
                models.add(mList.get(num2));
                mView.hideLoading();
                mView.showResultData(models);
            }
        }, 1300);
    }

    /**
     * 获取搜索记录
     */
    public void getHistoryData() {
        mView.showLoading();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String searchDtaJson = SpUtils.getPoemSearchData();
                if (gson == null) {
                    gson = new Gson();
                }
                if (!TextUtils.isEmpty(searchDtaJson)) {
                    try {
                        SearchModel shopSearchData = gson.fromJson(searchDtaJson, SearchModel.class);
                        if (shopSearchData != null) {
                            ArrayList<String> searchArrayList = shopSearchData.getSearchList();
                            if (searchArrayList != null) {
                                mView.hideLoading();
                                mView.showHistoryData(searchArrayList);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        mView.hideLoading();
                    }
                } else {
                    mView.hideLoading();
                    mView.showEmpty();
                }
            }
        }, 700);
    }

    /**
     * 删除搜索记录
     */
    public void deleteHistoryData() {
        mView.showLoading();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String searchDtaJson = SpUtils.getPoemSearchData();
                if (gson == null) {
                    gson = new Gson();
                }
                if (!TextUtils.isEmpty(searchDtaJson)) {
                    try {
                        SearchModel shopSearchData = gson.fromJson(searchDtaJson, SearchModel.class);
                        if (shopSearchData != null) {
                            ArrayList<String> searchArrayList = shopSearchData.getSearchList();
                            if (searchArrayList != null) {
                                searchArrayList.clear();
                                SpUtils.putPoemSearchData("");
                                mView.hideLoading();
                                mView.showEmpty();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        mView.hideLoading();
                        mView.showEmpty();
                    }
                } else {
                    mView.hideLoading();
                    mView.showEmpty();
                }
            }
        }, 1500);
    }

    /**
     * 保存搜索记录
     *
     * @param query
     */
    public void saveHistoryData(final String query) {
        mView.showLoading();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String searchDtaJson = SpUtils.getPoemSearchData();
                SearchModel shopSearchData = null;
                if (gson == null) {
                    gson = new Gson();
                }
                if (!TextUtils.isEmpty(searchDtaJson)) {
                    try {
                        shopSearchData = gson.fromJson(searchDtaJson, SearchModel.class);
                        if (shopSearchData != null) {

                            ArrayList<String> searchArrayList = shopSearchData.getSearchList();
                            if (searchArrayList != null) {
                                int num = searchArrayList.size();
                                if (num > 1) {
                                    if (num < 10) {
                                        if (!deleteSame(searchArrayList, query)) {
                                            searchArrayList.add(0, query);
                                        }
                                    } else {
                                        if (!deleteSame(searchArrayList, query)) {
                                            searchArrayList.remove(num - 1);
                                            searchArrayList.add(0, query);
                                        }
                                    }
                                } else {
                                    searchArrayList.add(query);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        mView.hideLoading();
                    }
                } else {
                    ArrayList<String> searchArrayList = new ArrayList<>(10);
                    searchArrayList.add(query);
                    shopSearchData = new SearchModel();
                    shopSearchData.setSearchList(searchArrayList);
                    mView.hideLoading();
                }

                if (shopSearchData != null) {
                    if (gson == null) {
                        gson = new Gson();
                    }
                    try {
                        String shopSearchDataJson = gson.toJson(shopSearchData);
                        SpUtils.putPoemSearchData(shopSearchDataJson);
                    } catch (Exception e) {
                        e.printStackTrace();
                        mView.hideLoading();
                    }
                }
            }
        }, 1600);
    }

    /**
     * 是否有相同的数据
     */
    private boolean deleteSame(ArrayList<String> searchArrayList, String newName) {
        boolean isSame = false;
        for (String name : searchArrayList) {
            if (newName.equals(name)) {
                isSame = true;
                break;
            }
        }
        return isSame;
    }
}
