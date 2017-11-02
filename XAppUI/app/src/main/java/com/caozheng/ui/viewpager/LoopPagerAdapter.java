package com.caozheng.ui.viewpager;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caozheng.ui.R;
import com.caozheng.ui.helper.DisplayHelper;

import java.util.List;

/**
 * @author caozheng
 * Created time on 2017/11/2
 * description:
 */

public class LoopPagerAdapter extends PagerAdapter {

    private SparseArray<Object> mScrapItems = new SparseArray<>();

    private List<ItemView> mItems;

    public LoopPagerAdapter(List<ItemView> mItems) {
        this.mItems = mItems;
    }

    @Override
    public int getCount() {
        //设置成最大，使用户看不到边界
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        //Warning：不要在这里调用removeView
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position %= mItems.size();
        if (position < 0){
            position = position * (-1);
        }

        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException
        ItemView itemView = mItems.get(position);
        ViewParent vp = itemView.getParent();
        if (vp!=null){
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(itemView);
        }

        container.addView(itemView);

        return itemView;
    }

    public static class ItemView extends LinearLayout {
        private TextView mTextView;
        private ImageView mImageView;

        public ItemView(Context context) {
            super(context);
            setOrientation(LinearLayout.VERTICAL);
            setGravity(Gravity.CENTER);

            int size = DisplayHelper.dp2px(context, 300);

            LinearLayout.LayoutParams imgLp = new LinearLayout.LayoutParams(size, size);
            imgLp.gravity = Gravity.CENTER;
            mImageView = new ImageView(context);
            addView(mImageView, imgLp);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.CENTER;

            mTextView = new TextView(context);
            mTextView.setTextSize(20);
            mTextView.setTextColor(ContextCompat.getColor(context, R.color.app_color_theme_5));
            mTextView.setGravity(Gravity.CENTER);
            mTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.color_white));
            addView(mTextView, lp);
        }

        public void setText(CharSequence text) {
            mTextView.setText(text);
        }

        public void setImage(String url){
            Glide.with(this).load(url).into(mImageView);
        }
    }
}
