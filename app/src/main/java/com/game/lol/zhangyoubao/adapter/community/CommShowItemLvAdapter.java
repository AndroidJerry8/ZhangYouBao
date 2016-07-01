package com.game.lol.zhangyoubao.adapter.community;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.model.CommShowCommentBean;
import com.game.lol.zhangyoubao.util.GlideCircleTransform;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/28 16:06
 * 创建描述：
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class CommShowItemLvAdapter extends BaseAdapter{
    private List<CommShowCommentBean.DataBean> data;
    private LayoutInflater mInflater;
    private Context context;

    public CommShowItemLvAdapter(Context context, List<CommShowCommentBean.DataBean> data) {
        this.data = data;
        this.context=context;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        Logger.i(data.size()+"");
        return data==null?0:data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh=null;
        if(convertView==null){

            convertView=mInflater.inflate(R.layout.comm_show_comment_item,parent,false);
            vh=new ViewHolder(convertView);

        }else {
            vh = (ViewHolder) convertView.getTag();
        }
            vh.tv_comment.setText(data.get(position).getContent());
            vh.tv_name.setText(data.get(position).getNickname());
            vh.tv_time.setText(data.get(position).getCreated().substring(5,16));
            Glide.with(context).load(data.get(position).getUser_avatar())
                    .placeholder(R.drawable.invite_fri)
                    .transform(new GlideCircleTransform(context))
                    .into(vh.iv_touxiang);
        return convertView;
    }
    public class ViewHolder{
        public ImageView iv_touxiang;
        public TextView tv_name;
        public TextView tv_time;
        public TextView tv_comment;
        public ViewHolder(View view) {
            iv_touxiang = (ImageView) view.findViewById(R.id.iv_touxiang);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_time = (TextView) view.findViewById(R.id.tv_time_comment);
            tv_comment = (TextView) view.findViewById(R.id.tv_comment);
            view.setTag(this);
        }
    }
}
