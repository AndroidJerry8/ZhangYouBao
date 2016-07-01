package com.game.lol.zhangyoubao.adapter.more;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.model.MoreBean;

import java.util.List;

/**
 * ====================================
 * 作者：CRain
 * 版本：1.0
 * 创建日期：2016/6/25 16:03
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */

public class MoreRecyclerViewAdapter extends RecyclerView.Adapter<MoreRecyclerViewAdapter.MoreHolder> {

    private List<MoreBean> list;
    private Context context;
    private int newWidth;

    public MoreRecyclerViewAdapter(List<MoreBean> list, Context context) {
        this.list = list;
        this.context = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        newWidth = displayMetrics.widthPixels / 4;
    }


    @Override
    public MoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.more_rv_item, parent, false);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = newWidth;
        params.height = newWidth;
        view.setLayoutParams(params);
        return new MoreHolder(view);
    }

    @Override
    public void onBindViewHolder(MoreHolder holder, int position) {

        MoreBean bean = list.get(position);
        if (bean.title != null) {
            holder.title.setText(bean.title);
            holder.ivItemMore.setImageResource(bean.imageId);
            holder.ivItemMore.setVisibility(View.VISIBLE);
        } else {
            holder.title.setText("");
            holder.ivItemMore.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MoreHolder extends RecyclerView.ViewHolder {
        ImageView ivItemMore;
        TextView title;

        public MoreHolder(View itemView) {
            super(itemView);
            ivItemMore = (ImageView) itemView.findViewById(R.id.iv_more_image);
            title = (TextView) itemView.findViewById(R.id.tv_more_text);
        }
    }
}
