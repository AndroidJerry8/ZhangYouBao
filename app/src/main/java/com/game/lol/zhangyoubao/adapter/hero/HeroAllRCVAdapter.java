package com.game.lol.zhangyoubao.adapter.hero;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.db.DBHelperDao;
import com.game.lol.zhangyoubao.model.DBHeroListBean;
import com.game.lol.zhangyoubao.model.HeroFreeBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/28 21:35
 * 创建描述：本周周免的Adapter
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class HeroAllRCVAdapter extends RecyclerView.Adapter<HeroAllRCVAdapter.HeroHolder> {
    private final AssetManager assets;
    private final DBHelperDao dbDao;
    private List<DBHeroListBean> list;
    private Context context;
    //    private SQLiteDatabase db;
    private static final String TAG = "HeroAllRCVAdapter";

    public HeroAllRCVAdapter(Context context, List<DBHeroListBean> list) {
        this.list = list;
        this.context = context;
        Log.i(TAG, "HeroAllRCVAdapter : " + list.size());
        assets = context.getAssets();
        dbDao = DBHelperDao.getInstance(context).openDB();
    }

    @Override
    public HeroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.hero_free_item, null);
        return new HeroHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroHolder holder, final int position) {
        DBHeroListBean dbHeroListBean = list.get(position);
        String id = dbHeroListBean.getId();
        holder.tvHeroNickName.setText(dbHeroListBean.getNickname());
        holder.tvCellMoney.setText(dbHeroListBean.getMoney());
        holder.tvCellPoint.setText(dbHeroListBean.getPoint());
        String duoname = dbHeroListBean.getDuoname();
        Glide.with(context)
                .load("file:///android_asset/hero/pic/hero/" + duoname + ".jpg")
                .placeholder(R.mipmap.global_bg_square_circular)
                .error(R.mipmap.global_bg_square_circular)
                .centerCrop()
                .into(holder.ivHeroHead);

        itemClickListener.onItemClick(holder.itemView, Integer.parseInt(id));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class HeroHolder extends RecyclerView.ViewHolder {
        private ImageView ivHeroHead, ivHeroHeadGrid;
        private TextView tvHeroNickName, tvCellMoney, tvCellPoint;

        public HeroHolder(View itemView) {
            super(itemView);
            ivHeroHead = (ImageView) itemView.findViewById(R.id.iv_hero_head);
            ivHeroHeadGrid = (ImageView) itemView.findViewById(R.id.iv_hero_head_grid);
            tvHeroNickName = (TextView) itemView.findViewById(R.id.tv_hero_nickname);
            tvCellMoney = (TextView) itemView.findViewById(R.id.tv_cell_money);
            tvCellPoint = (TextView) itemView.findViewById(R.id.tv_cell_point);

        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 回调接口
    ///////////////////////////////////////////////////////////////////////////
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;

    }

    public interface OnItemClickListener {
        void onItemClick(View view, int itemId);
    }

}
