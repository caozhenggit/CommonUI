package com.caozheng.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.caozheng.ui.viewpager.CardTransformer;
import com.caozheng.ui.viewpager.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author caozheng
 * Created time on 2017/11/2
 *
 * description:
 */
public class LoopViewPagerActivity extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    private List<LoopPagerAdapter.ItemView> mItems = new ArrayList<LoopPagerAdapter.ItemView>();
    private String[] imageUrl = new String[]{
              "https://ws1.sinaimg.cn/large/610dc034ly1fjxu5qqdjoj20qo0xc0wk.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fk05lf9f4cj20u011h423.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fjs25xfq48j20u00mhtb6.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fjqw4n86lhj20u00u01kx.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fjppsiclufj20u011igo5.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fjndz4dh39j20u00u0ada.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fjgfyxgwgnj20u00gvgmt.jpg"
            , "https://ws1.sinaimg.cn/large/610dc034ly1fjfae1hjslj20u00tyq4x.jpg"};

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_viewpager);
        ButterKnife.bind(this);

        mContext = this;

        initData(imageUrl.length);
        initPagers();
    }

    private void initData(int count) {
        for (int i = 0; i < count; i++) {
            LoopPagerAdapter.ItemView itemView = new LoopPagerAdapter.ItemView(mContext);
            itemView.setText(String.valueOf(i));
            itemView.setImage(imageUrl[i]);

            mItems.add(itemView);
        }
    }

    private void initPagers() {
        LoopPagerAdapter pagerAdapter = new LoopPagerAdapter(mItems);

        boolean canUseHardware = Build.VERSION.SDK_INT >= 21;
        mViewPager.setPageTransformer(false, new CardTransformer(),
                canUseHardware ? ViewCompat.LAYER_TYPE_HARDWARE : ViewCompat.LAYER_TYPE_SOFTWARE);
        mViewPager.setAdapter(pagerAdapter);
    }
}
