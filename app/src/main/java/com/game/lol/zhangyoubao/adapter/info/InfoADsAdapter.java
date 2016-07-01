package com.game.lol.zhangyoubao.adapter.info;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.game.lol.zhangyoubao.R;
import com.game.lol.zhangyoubao.model.InfoADBean;

import java.util.List;

/**
 * ====================================
 * 作者：付明明
 * 版本：1.0
 * 创建日期：2016/6/28 12:09
 * 创建描述：轮播广告ViewPager的适配器
 * 更新日期：
 * 更新描述：
 * ====================================
 */
public class InfoADsAdapter extends PagerAdapter {

    private List<InfoADBean.DataBean> infoAdBeanList;
    private Context context;

    public InfoADsAdapter(Context context, List<InfoADBean.DataBean> infoAdBeanList) {
        this.infoAdBeanList = infoAdBeanList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.info_ad_item, null);
        ImageView ivInfoAd = (ImageView) view.findViewById(R.id.iv_info_ad);
        int newPosition = position % infoAdBeanList.size();
        String pic_ad_url = infoAdBeanList.get(newPosition).getPic_ad_url();
        Glide.with(context)
                .load(pic_ad_url)
                .placeholder(R.mipmap.global_image_load_default)
                .error(R.mipmap.global_image_load_default)
                .crossFade()
                .into(ivInfoAd);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
