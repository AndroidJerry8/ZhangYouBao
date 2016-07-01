package com.game.lol.zhangyoubao.adapter.base;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.1
 * 创建日期：2016/5/6
 * 创建描述：
 * 更新日期：2016/5/31
 * 更新描述：增加了updateList()方法，更新适配器数据时调用此方法
 * ====================================
 */
public abstract class ListViewCommonAdapter<T> extends BaseAdapter {

    private Context mContext; // 上下文
    private List<T> data; // 数据源
    private int layoutId; // 布局文件的ID

    public ListViewCommonAdapter(Context context, List<T> data, int layoutId) {
        this.data = data;
        this.mContext = context;
        this.layoutId = layoutId;
    }

    /**
     * 更新数据源时执行的方法
     *
     * @param data 要更新的List集合
     */
    public void updateList(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取一个ViewHolder
        ViewHolder holder = ViewHolder.getViewHolder(mContext, convertView, layoutId);
        // 实现设置Item内数据的抽象方法
        setItemContent(holder, getItem(position));
        return holder.getConvertView();
    }

    /**
     * 设置item里数据的抽象方法，用来设置item内的内容
     *
     * @param holder item布局对应的holder对象
     * @param t      List对应的实体类
     */
    public abstract void setItemContent(ViewHolder holder, T t);

    /**
     * 内部类通用ViewHolder
     *
     * @author Jerry
     * @date 2016.05.06
     */
    @SuppressWarnings("unused")
    public static class ViewHolder {
        private SparseArray<View> mViews; // 类似于Map集合
        private View mConvertView; // 存储ViewHolder保存的View

        private ViewHolder(Context context, int layoutId) {
            mViews = new SparseArray<View>(); // 创建一个SparseArray 对象
            this.mConvertView = View.inflate(context, layoutId, null);
            mConvertView.setTag(this);
        }

        // 通过静态方法获得一个ViewHolder对象
        public static ViewHolder getViewHolder(Context context, View convertView, int layoutId) {
            if (convertView == null) {
                return new ViewHolder(context, layoutId);
            } else {
                return (ViewHolder) convertView.getTag();
            }
        }

        /**
         * 获取ViewHolder里对应的View对象
         *
         * @return
         */
        public View getConvertView() {
            return mConvertView;
        }

        /**
         * 通过控件的Id获取对于的控件，如果没有则加入view
         *
         * @param viewId 控件的Id
         * @return
         */
        @SuppressWarnings("unchecked")
        public <T extends View> T getViewById(int viewId) {
            View view = mViews.get(viewId);
            // 判断mViews集合里是否含有这个viewId对应的view，没有则查找，有则直接返回
            if (view == null) {
                view = mConvertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }

        /**
         * 为Item中的TextView设置数据
         *
         * @param viewId 控件的Id
         * @param text 文本信息
         * @return
         */
        public ViewHolder setText(int viewId, CharSequence text) {
            TextView view = getViewById(viewId);
            view.setText(text);
            return this;
        }

        /**
         * 为Item中的ImageView设置数据
         *
         * @param viewId 控件Id
         * @param drawableId 资源文件的Id
         * @return
         */
        public ViewHolder setImageResource(int viewId, int drawableId) {
            ImageView view = getViewById(viewId);
            view.setImageResource(drawableId);
            return this;
        }

        /**
         * 为Item中的ImageView设置数据
         *
         * @param viewId 控件Id
         * @param bitmap Bitmap图像
         * @return
         */
        public ViewHolder setImageResource(int viewId, Bitmap bitmap) {
            ImageView view = getViewById(viewId);
            view.setImageBitmap(bitmap);
            return this;
        }

    }

}
