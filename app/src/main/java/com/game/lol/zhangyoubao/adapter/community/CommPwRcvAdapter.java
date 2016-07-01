package com.game.lol.zhangyoubao.adapter.community;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.util.PixelUtil;

/**
 * ====================================
 * 作者：王月丽
 * 版本：1.0
 * 创建日期：2016/6/26 8:58
 * 创建描述：popupwindows的适配器
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class CommPwRcvAdapter extends RecyclerView.Adapter<CommPwRcvAdapter.MyHolder> implements View.OnClickListener {
    String[] btns=new String[]{};
    Context context;

    public void ClickCallback(PwItemClick pwItemClick){
        this.pwItemClick=pwItemClick;
    }
    public interface PwItemClick{
        void ItemClick(View v, String id);
    }

    private PwItemClick pwItemClick=null;
    public CommPwRcvAdapter(String[] btns, Context context) {
        this.btns = btns;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.comm_pw_custom_btn,parent,false);
        MyHolder mHolder=new MyHolder(v);
//        v.setOnClickListener(this);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.btn.setText(btns[position]);
        holder.btn.setTag(btns[position]);
//        holder.btn.setBackgroundResource(R.drawable.community_pop_btn);
        //  holder.btn.setHeight(20);
//       RecyclerView.LayoutParams lp=new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
//        //LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        holder.btn.setLayoutParams(lp);
//        holder.btn.setHeight(5);

        //lp.gravity = Gravity.RIGHT;
        if (position == 0) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.btn.getLayoutParams();
            params.topMargin = PixelUtil.dp2px(context,7);
        }
//此处相当于布局文件中的Android：gravity属性
        holder.btn.setGravity(Gravity.CENTER);

        holder.btn.setOnClickListener(this);


    }

    @Override
    public int getItemCount() {
        return btns==null?0:btns.length;
    }

    @Override
    public void onClick(View v) {
        if(pwItemClick!=null){
            pwItemClick.ItemClick(v, (String) v.getTag());
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView btn;
        public MyHolder(View itemView) {
            super(itemView);
            btn= (TextView) itemView.findViewById(R.id.comm_pw_btn);
        }
    }
}
