package com.hy.yonghuangl.pagertoptabindicator.weigth;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.hy.libary.PagerTabIndicator;
import com.hy.yonghuangl.pagertoptabindicator.R;


public class MainActivity extends AppCompatActivity {
    private PagerTabIndicator tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    private DisplayMetrics dm; // 获取当前屏幕密度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = (PagerTabIndicator) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        setTabsProperty();

        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 设置标签栏的属性以及状态
     */
    private void setTabsProperty() {
        dm = getResources().getDisplayMetrics();
        // 设置Tab Indicator的颜色
        tabs.setIndicatorColor(Color.RED);
        // 设置Tab是自动填充满屏幕的
        tabs.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        tabs.setDividerColor(Color.TRANSPARENT);
        // 设置Tab底部线的高度
        tabs.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 2, dm));
        // 设置Tab标题文字的大小
        tabs.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 15, dm));
        // 设置Tab标题默认的颜色
        tabs.setTextColor(Color.BLACK);
        // 设置选中Tab标题的颜色
        tabs.setSelectTextColor(Color.GREEN);
        // 设置Tab底部线的颜色
        //tabs.setUnderlineColor(Color.GREEN);
        // 取消点击Tab时的背景色
        // tabs.setTabBackground(getResources().getColor(R.color.tab_pressed_hover));
        //选中的TextSize
        tabs.setSelectedTabTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 18, dm));
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = { "Categories", "Home", "Top Paid", "Top Free", "Top Grossing", "Top New Paid",
                "Top New Free", "Trending" };

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            return new MyFragment();
        }

    }
}
