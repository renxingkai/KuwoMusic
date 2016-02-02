package com.example.administrator.kuwomusic;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * ViewPagerAdapter
 *
 * @author: Xingkai Ren
 * @time: 2016/2/2  9:50
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> views;
    private Context context;

//    public ViewPagerAdapter(List<View> views,Context context){
//        this.views=views;

    public ViewPagerAdapter(List<View> views, Context context) {
        this.views = views;
        this.context = context;
    }


//        this.context=context;
//    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }
}
