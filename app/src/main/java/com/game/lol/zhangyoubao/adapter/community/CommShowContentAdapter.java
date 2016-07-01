package com.game.lol.zhangyoubao.adapter.community;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.model.CommShowAllBean;
import com.game.lol.zhangyoubao.util.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/27 8:36
 * 创建描述：社区页面真人秀activity中的内容
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class CommShowContentAdapter extends RecyclerView.Adapter<CommShowContentAdapter.MyHolder> implements View.OnClickListener {

    public void IShowItemClick(IShowItemClick showItemClick){
        this.showItemClick=showItemClick;
    }
    public interface IShowItemClick{
        void getItemId(View v, String id);
    }
    private IShowItemClick showItemClick;

    private Context context;

    private List<CommShowAllBean.DataBean> allList=new ArrayList<>();

    public CommShowContentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comm_show_item, null);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.itemView.setTag(allList.get(position).getId());
        holder.tv1Nickname.setText(allList.get(position).getNickname());
        holder.tv2Summoner.setText("召唤师：（"+allList.get(position).getArea()+")"+allList.get(position).getSummoner());
        String time=allList.get(position).getCreated().substring(11,16);
        holder.tv3Time.setText(time);
        holder.tv4Desc.setText(allList.get(position).getDesc());
      //  holder.ivAvatarIcon;
        Glide.with(context)
                .load(allList.get(position).getAvatar())
                .placeholder(R.drawable.invite_fri)
                .centerCrop()
                .transform(new GlideCircleTransform(context))
                .into(holder.ivAvatarIcon);
        // holder.ivContentPic
        Glide.with(context).load(allList.get(position).getPic_url()).into(holder.ivContentPic);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return allList == null ? 0 : allList.size();
    }

    @Override
    public void onClick(View v) {
        if (showItemClick!=null){
            showItemClick.getItemId(v, (String) v.getTag());
        }
    }


    class MyHolder extends RecyclerView.ViewHolder {
        private  ImageView ivAvatarIcon;
        private TextView tv1Nickname;
        private TextView tv2Summoner;
        private TextView tv3Time;
        private ImageView ivContentPic;
        private TextView tv4Desc;

        public MyHolder(View itemView) {
            super(itemView);
            ivAvatarIcon= (ImageView) itemView.findViewById(R.id.iv_avatar_icon);
            ivContentPic= (ImageView) itemView.findViewById(R.id.iv_content_pic);
            tv1Nickname= (TextView) itemView.findViewById(R.id.tv1_nickname);
            tv2Summoner= (TextView) itemView.findViewById(R.id.tv2_summoner);
            tv3Time= (TextView) itemView.findViewById(R.id.tv3_time);
            tv4Desc= (TextView) itemView.findViewById(R.id.tv4_desc);
        }

    }
    public void updataList(List<CommShowAllBean.DataBean> allList){
        this.allList=allList;
        notifyDataSetChanged();
    }
}
