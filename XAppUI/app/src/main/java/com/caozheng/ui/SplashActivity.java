package com.caozheng.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.caozheng.ui.splashview.SplashView;

/**
 * @author 10744
 * @date 2017/11/19
 * <p>
 * describe:
 */
public class SplashActivity extends Activity {

    private static final int DURATION_TIME = 3;
    private static final String IMAGE_URL = "https://ws1.sinaimg.cn/large/d23c7564ly1fg6qckyqxkj20u00zmaf1.jpg";
    private static final String ACTION_URL = "https://github.com/caozhenggit/CommonUI";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SplashView.showSplashView(this, DURATION_TIME, R.mipmap.ic_launcher, new SplashView.OnSplashViewActionListener() {
            @Override
            public void onSplashImageClick(String actionUrl) {

            }

            @Override
            public void onSplashViewDismiss(boolean initiativeDismiss) {
                finish();
            }
        });

        SplashView.updateSplashData(this, IMAGE_URL, ACTION_URL);
    }
}
