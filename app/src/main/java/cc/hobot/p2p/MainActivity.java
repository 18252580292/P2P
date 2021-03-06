package cc.hobot.p2p;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import cc.hobot.p2p.fragment.TestFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabs = (FragmentTabHost) findViewById(android.R.id.tabhost);
        initBottomTabs();
    }

    private void initBottomTabs() {
        mTabs.setup(this, getSupportFragmentManager(), R.id.fl_container);
        TabHost.TabSpec homeTab = mTabs.newTabSpec("home").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_home_selector, "首页"));
        mTabs.addTab(homeTab, TestFragment.class, null);
        TabHost.TabSpec investTab = mTabs.newTabSpec("invest").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_invest_selector, "资产"
        ));
        mTabs.addTab(investTab, TestFragment.class, null);
        TabHost.TabSpec myTab = mTabs.newTabSpec("my").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_my_selector, "我的"
        ));
        mTabs.addTab(myTab, TestFragment.class, null);
        TabHost.TabSpec moreTab = mTabs.newTabSpec("more").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_more_selector, "更多"
        ));
        mTabs.addTab(moreTab, TestFragment.class, null);
    }

    private View getBottomTabItemView(@DrawableRes int resId, @NonNull String name) {
        View view = View.inflate(this, R.layout.main_bottom_tab_view, null);
        ImageView iv = view.findViewById(R.id.tab_img);
        TextView tv = view.findViewById(R.id.tab_tv);
        tv.setText(name);
        iv.setBackgroundResource(resId);
        return view;
    }


}
