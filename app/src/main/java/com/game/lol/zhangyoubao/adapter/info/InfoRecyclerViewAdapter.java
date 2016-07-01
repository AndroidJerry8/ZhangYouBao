package com.game.lol.zhangyoubao.adapter.info;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.model.InfoListBean;
import com.game.lol.zhangyoubao.util.GlideRoundTransform;
import com.game.lol.zhangyoubao.util.TimeFormatUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/25 18:28
 * 创建描述：资讯界面里 RecyclerView 的Adapter
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class InfoRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_TEXT = 1;
    public static final int VIEW_TYPE_IMAGE = 2;
    public static final int VIEW_TYPE_VIDEO = 3;
    private static final String TAG = "InfoRecyclerViewAdapter";
    private Context context;
    private List<InfoListBean.DataBean> infoListBeanList;
    private int ViewType;

    public InfoRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    /**
     * 分页加载添加数据
     *
     * @param infoListBeanList 新一页的List集合
     */
    public void updateListBeanList(List<InfoListBean.DataBean> infoListBeanList) {

        this.infoListBeanList = infoListBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        String pic_url = infoListBeanList.get(position).getPic_url();
        String video_url = infoListBeanList.get(position).getVideo_url();
        if (!TextUtils.isEmpty(video_url)) {
            return VIEW_TYPE_VIDEO;
        } else if (!TextUtils.isEmpty(pic_url) && TextUtils.isEmpty(video_url)) {
            return VIEW_TYPE_VIDEO;
        } else {
            return VIEW_TYPE_TEXT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case VIEW_TYPE_TEXT:
                itemView = View.inflate(context, R.layout.info_text_item, null);
                holder = new TextViewHolder(itemView);
                break;
            case VIEW_TYPE_IMAGE:    //图片的条目
                itemView = View.inflate(context, R.layout.info_image_item, null);
                holder = new ImageViewHolder(itemView);
                break;
            case VIEW_TYPE_VIDEO:    //视频的条目
                itemView = View.inflate(context, R.layout.info_video_item, null);
                holder = new VideoViewHolder(itemView);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        String title = infoListBeanList.get(position).getTitle();
        String desc = infoListBeanList.get(position).getDesc();
        int recommend = infoListBeanList.get(position).getRecommend();
        int published = infoListBeanList.get(position).getPublished();
        //时间格式化
        String formatTime = TimeFormatUtil.getFormatTime(published);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_TEXT:
                TextViewHolder textViewHolder = (TextViewHolder) holder;
                if (recommend == 1)
                    textViewHolder.ivTextRecommend.setVisibility(View.VISIBLE);
                textViewHolder.tvTextTitle.setText(title);
                textViewHolder.tvTextDesc.setText(desc);
                textViewHolder.tvTextpublished.setText(formatTime);
                break;
            case VIEW_TYPE_IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                if (recommend == 1)
                    imageViewHolder.ivImageReconmmed.setVisibility(View.VISIBLE);
                imageViewHolder.tvImageTitle.setText(title);
                imageViewHolder.tvImageDesc.setText(desc);
                imageViewHolder.tvImagepublished.setText(formatTime);
                Glide.with(context)
                        .load(infoListBeanList.get(position).getPic_url())
                        .placeholder(R.mipmap.global_list_item_circular_default)
                        .error(R.mipmap.global_list_item_circular_default)
                        .bitmapTransform(new GlideRoundTransform(context))
                        .crossFade()
                        .into(imageViewHolder.ivImagePic);
                break;
            case VIEW_TYPE_VIDEO:
                VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
                if (recommend == 1)
                    videoViewHolder.ivVideoRecommend.setVisibility(View.VISIBLE);
                videoViewHolder.tvVideoTitle.setText(title);
                videoViewHolder.tvVideoDesc.setText(desc);
                videoViewHolder.tvVideopublished.setText(formatTime);
                Glide.with(context)
                        .load(infoListBeanList.get(position).getPic_url())
                        .placeholder(R.mipmap.global_list_item_circular_default)
                        .error(R.mipmap.global_list_item_circular_default)
                        .bitmapTransform(new GlideRoundTransform(context))
                        .crossFade()
                        .into(videoViewHolder.ivVideoPic);
                break;
        }
        String itemId = infoListBeanList.get(position).getId();
        itemClickListener.onItemClick(holder.itemView, Integer.parseInt(itemId));
    }

    @Override
    public int getItemCount() {
        return infoListBeanList == null ? 0 : infoListBeanList.size();
    }

    /**
     * 资讯界面里的纯文字条目的模块
     */
    static class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTextTitle, tvTextDesc, tvTextpublished;
        private ImageView ivTextRecommend;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvTextTitle = (TextView) itemView.findViewById(R.id.tv_text_title);
            tvTextDesc = (TextView) itemView.findViewById(R.id.tv_text_desc);
            tvTextpublished = (TextView) itemView.findViewById(R.id.tv_text_published);
            ivTextRecommend = (ImageView) itemView.findViewById(R.id.iv_text_recommend);

        }
    }

    /**
     * 资讯界面里的没有视频条目的模块
     */
    static class ImageViewHolder extends RecyclerView.ViewHolder {
        private TextView tvImageTitle, tvImageDesc, tvImagepublished;
        private ImageView ivImagePic, ivImageReconmmed;

        public ImageViewHolder(View itemView) {
            super(itemView);
            tvImageTitle = (TextView) itemView.findViewById(R.id.tv_image_title);
            tvImageDesc = (TextView) itemView.findViewById(R.id.tv_image_desc);
            tvImagepublished = (TextView) itemView.findViewById(R.id.tv_image_published);
            ivImagePic = (ImageView) itemView.findViewById(R.id.iv_image_pic);
            ivImageReconmmed = (ImageView) itemView.findViewById(R.id.iv_image_recommend);
        }
    }

    /**
     * 资讯界面里的有视频条目的模块
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvVideoTitle, tvVideoDesc, tvVideopublished;
        private ImageView ivVideoPic, ivVideoRecommend;

        public VideoViewHolder(View itemView) {
            super(itemView);
            tvVideoTitle = (TextView) itemView.findViewById(R.id.tv_video_title);
            tvVideoDesc = (TextView) itemView.findViewById(R.id.tv_video_desc);
            tvVideopublished = (TextView) itemView.findViewById(R.id.tv_video_published);
            ivVideoPic = (ImageView) itemView.findViewById(R.id.iv_video_pic);
            ivVideoRecommend = (ImageView) itemView.findViewById(R.id.iv_video_recommend);
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
