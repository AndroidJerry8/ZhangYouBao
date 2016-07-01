package com.game.lol.zhangyoubao.adapter.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.constant.Key;
import com.game.lol.zhangyoubao.constant.Type;
import com.game.lol.zhangyoubao.model.VideoListBean;
import com.game.lol.zhangyoubao.model.VideoUpdateBean;
import com.game.lol.zhangyoubao.util.GlideRoundTransform;
import com.game.lol.zhangyoubao.util.RetrofitUtil;
import com.game.lol.zhangyoubao.util.TimeFormatUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/24 16:10
 * 创建描述：视频界面里 RecyclerView 的Adapter
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoRecyclerViewAdapter.VideoHolder> {
    private static final String TAG = "VideoRCVAdapter";
    private LayoutInflater inflater;
    private int newWidth;
    private Context context;
    private List<VideoListBean.DataBean.CatwordIdBean> videoListBeanList;
    private RetrofitUtil<VideoUpdateBean> updateBeanRetrofitUtil;
    private List<VideoUpdateBean.DataBean> videoUpdateListBean;

    public VideoRecyclerViewAdapter(Context context, List<VideoListBean.DataBean.CatwordIdBean> videoListBeanList) {
        this.context = context;
        this.videoListBeanList = videoListBeanList;
        inflater = LayoutInflater.from(context);
        updateBeanRetrofitUtil = new RetrofitUtil<>(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        newWidth = displayMetrics.widthPixels / 3;
        initUpdateData();
    }

    /**
     * 视频条目更新时间Data
     */
    private void initUpdateData() {
        Map<String, String> params = new HashMap<>();
        params.put(Key.cattype, "video");
        updateBeanRetrofitUtil.getLOLBeanDataFromNet(Type.CATALOGS_SERVICE, Type.vlistUpdateTime, params, VideoUpdateBean.class, new RetrofitUtil.CallBack<VideoUpdateBean>() {
            @Override
            public void onLoadingDataComplete(VideoUpdateBean body) {
                videoUpdateListBean = body.getData();
                notifyDataSetChanged();
            }

            @Override
            public void onLoadingDataFailed(Throwable t) {
                Toast.makeText(context, "视频界面更新时间数据加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    /**
//     * 更新数据,带时间的
//     *
//     * @param videoListBeanList
//     */
//    public void updateList(List<VideoListBean.DataBean.CatwordIdBean> videoListBeanList) {
//        this.videoListBeanList = videoListBeanList;
//        notifyDataSetChanged();
//    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = View.inflate(context, R.layout.video_rvc_item, null);
        View itemView = inflater.inflate(R.layout.video_rvc_item, parent, false);
        ViewGroup.LayoutParams params = itemView.getLayoutParams();
        params.width = newWidth;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        itemView.setLayoutParams(params);
        return new VideoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        ImageView ivItemBg = holder.ivItemBg;
        TextView tvItemTitle = holder.tvItemTitle;
        TextView tvUpdateTime = holder.tvUpdateTime;
        tvItemTitle.setText(videoListBeanList.get(position).getName());
        Glide.with(context)
                .load(videoListBeanList.get(position).getPic_url())
                .placeholder(R.mipmap.global_bg_square_circular)
                .error(R.mipmap.global_bg_square_circular)
                .centerCrop()
                .bitmapTransform(new GlideRoundTransform(context, 8))
                .crossFade()
                .into(ivItemBg);
        String itemId = videoListBeanList.get(position).getId();
        itemClickListener.onItemClick(holder.itemView, Integer.parseInt(itemId));
        //设置时间
        if (videoUpdateListBean != null) {
            VideoListBean.DataBean.CatwordIdBean catwordIdBean = videoListBeanList.get(position);
            String id = catwordIdBean.getId();
            //将时间的List遍历一遍，找出Id跟catwordIdBean 里Id一样的，
            for (int i = 0; i < videoUpdateListBean.size(); i++) {
                VideoUpdateBean.DataBean updateBean = videoUpdateListBean.get(i);
                String updateId = updateBean.getId();
                if (catwordIdBean.getId().equals(updateId)) {
                    String formatTime = TimeFormatUtil.getVideoFormatTime(updateBean.getUpdated());
                    tvUpdateTime.setText(formatTime);
                    break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return videoListBeanList.size();
    }

    static class VideoHolder extends RecyclerView.ViewHolder {

        ImageView ivItemBg;
        TextView tvUpdateTime;
        TextView tvItemTitle;

        public VideoHolder(View itemView) {
            super(itemView);
            ivItemBg = (ImageView) itemView.findViewById(R.id.iv_item_bg);
            tvUpdateTime = (TextView) itemView.findViewById(R.id.tv_update_time);
            tvItemTitle = (TextView) itemView.findViewById(R.id.tv_item_title);

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
