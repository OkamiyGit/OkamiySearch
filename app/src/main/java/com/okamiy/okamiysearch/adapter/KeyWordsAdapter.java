package com.okamiy.okamiysearch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.okamiy.okamiysearch.R;
import com.okamiy.okamiysearch.activity.model.KeyWordsModel;
import com.okamiy.okamiysearch.global.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 13:49
 */
public class KeyWordsAdapter extends SimpleRecAdapter<KeyWordsModel, KeyWordsAdapter.ViewHolder> {

    public KeyWordsAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_keyword_s;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final KeyWordsModel model = data.get(position);
        holder.mTextView.setText(model.getKeyWord());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRecItemClick().onItemClick(position, model, Constant.ITEM_CLICK, holder);
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_keyword)
        TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
