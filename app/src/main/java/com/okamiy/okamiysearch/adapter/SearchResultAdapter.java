package com.okamiy.okamiysearch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.okamiy.okamiysearch.R;
import com.okamiy.okamiysearch.activity.model.ResultModel;
import com.okamiy.okamiysearch.global.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 13:49
 */
public class SearchResultAdapter extends SimpleRecAdapter<ResultModel, SearchResultAdapter.ViewHolder> {

    public SearchResultAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_result_search;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ResultModel model = data.get(position);
        holder.mIvPhoto.setImageResource(model.getImg());
        holder.mTvTitle.setText(model.getTitle());
        holder.mTvSort.setText(model.getSort());
        holder.mTvAge.setText(String.format("%s岁", model.getRange()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRecItemClick().onItemClick(position, model, Constant.ITEM_CLICK, holder);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView mIvPhoto;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_sort)
        TextView mTvSort;
        @BindView(R.id.tv_age)
        TextView mTvAge;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
