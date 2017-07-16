package cc.hobot.p2p;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import cc.hobot.p2p.fragment.FragmentFactory;
import cc.hobot.p2p.util.ToastUtils;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost mTabs;
    private boolean isFirstClick = true;
    private long currentTime;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            currentTime = 0;
            isFirstClick = true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabs = (FragmentTabHost) findViewById(android.R.id.tabhost);
        initBottomTabs();
    }

    private void initBottomTabs() {
        mTabs.setup(this, getSupportFragmentManager(), R.id.fl_container);

        //home interface
        TabHost.TabSpec homeTab = mTabs.newTabSpec("home").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_home_selector, "首页"));
        mTabs.addTab(homeTab, FragmentFactory.getFragment(0).getClass(), null);

        //invest interface
        TabHost.TabSpec investTab = mTabs.newTabSpec("invest").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_invest_selector, "资产"
        ));
        mTabs.addTab(investTab, FragmentFactory.getFragment(1).getClass(), null);

        //my interface
        TabHost.TabSpec myTab = mTabs.newTabSpec("my").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_my_selector, "我的"
        ));
        mTabs.addTab(myTab, FragmentFactory.getFragment(2).getClass(), null);


        //more interface
        TabHost.TabSpec moreTab = mTabs.newTabSpec("more").setIndicator(getBottomTabItemView(
                R.drawable.main_bottom_more_selector, "更多"
        ));
        mTabs.addTab(moreTab, FragmentFactory.getFragment(3).getClass(), null);
    }

    private View getBottomTabItemView(@DrawableRes int resId, @NonNull String name) {
        View view = View.inflate(this, R.layout.main_bottom_tab_view, null);
        ImageView iv = view.findViewById(R.id.tab_img);
        TextView tv = view.findViewById(R.id.tab_tv);
        tv.setText(name);
        iv.setBackgroundResource(resId);
        return view;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //双击退出应用
        if (keyCode == KeyEvent.KEYCODE_BACK && isFirstClick) {
            currentTime = SystemClock.currentThreadTimeMillis();
            ToastUtils.showToastShort(this, "再次点击退出应用");
            isFirstClick = false;
            mHandler.sendEmptyMessageDelayed(0, 2000);
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
