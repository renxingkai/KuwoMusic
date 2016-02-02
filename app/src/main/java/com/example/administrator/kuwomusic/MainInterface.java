package com.example.administrator.kuwomusic;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainInterface extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = "MainInterface";

    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;

    private ImageView[] dots;
    private int[] ids = {R.id.iv1, R.id.iv2, R.id.iv3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maininterface);
        initViews();
        initDots();

    }

    /**
     * 对于滑动图片的操作
     */
    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);

        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.one, null));
        views.add(inflater.inflate(R.layout.two, null));
        views.add(inflater.inflate(R.layout.three, null));

        vpAdapter = new ViewPagerAdapter(views, this);
        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);
        vp.setOnPageChangeListener(this);
    }

    /**
     * 对于导航点的操作
     */
    private void initDots() {

        dots = new ImageView[views.size()];
        //通过循环找到id
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) findViewById(ids[i]);
        }
    }

    /**
     * 页面被滑动时调用
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 新的页面被选中时调用
     *
     * @param position
     */
    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < ids.length; i++) {
            if (position == i) {
                dots[i].setImageResource(R.drawable.light);
            } else {
                dots[i].setImageResource(R.drawable.dark);
            }
        }
    }

    /**
     * 滑动状态改变时调用
     *
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
