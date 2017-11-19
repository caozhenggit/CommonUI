package com.caozheng.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.caozheng.ui.dialog.BottomSheetDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author caozheng
 * @date 2017/11/19
 * <p>
 * describe:
 */

public class BottomSheetDialogActivity extends AppCompatActivity {

    @Bind(R.id.lv)
    ListView mLv;

    private String[] items = new String[]{
            "list_文字",
            "list_文字+图片",
            "grid_文字+图片",
    };

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_dialog);
        ButterKnife.bind(this);

        mContext = this;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext
                , android.R.layout.simple_list_item_1
                ,  android.R.id.text1
                , items);

        mLv.setAdapter(arrayAdapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        showBottomList1();
                        break;

                    case 1:
                        showBottomList2();
                        break;

                    case 2:
                        showBottomGrid();
                        break;

                    default:
                        break;
                }
            }
        });
    }

    private void showBottomList1() {
        new BottomSheetDialog.BottomListSheetBuilder(mContext, true)
                .addItem("Item 0")
                .addItem("Item 1")
                .addItem("Item 2")
                .setCheckedIndex(0)
                .setOnSheetItemClickListener(new BottomSheetDialog.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(BottomSheetDialog dialog, View itemView, int position, String tag) {
                        Toast.makeText(mContext, "点击了 Item" + position, Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                }).build().show();
    }

    private void showBottomList2() {
        new BottomSheetDialog.BottomListSheetBuilder(mContext)
                .addItem(R.mipmap.ic_launcher, "Item 0")
                .addItem(R.mipmap.ic_launcher, "Item 1")
                .addItem(R.mipmap.ic_launcher, "Item 2")
                .setOnSheetItemClickListener(new BottomSheetDialog.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(BottomSheetDialog dialog, View itemView, int position, String tag) {
                        Toast.makeText(mContext, "点击了 Item" + position, Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                }).build().show();
    }

    private void showBottomGrid() {
        final int TAG_SHARE_WECHAT_FRIEND = 0;
        final int TAG_SHARE_WECHAT_MOMENT = 1;
        final int TAG_SHARE_WEIBO = 2;
        final int TAG_SHARE_CHAT = 3;
        final int TAG_SHARE_LOCAL = 4;
        BottomSheetDialog.BottomGridSheetBuilder builder = new BottomSheetDialog.BottomGridSheetBuilder(mContext);
        builder.addItem(R.mipmap.icon_more_operation_share_friend, "分享到微信", TAG_SHARE_WECHAT_FRIEND, BottomSheetDialog.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_moment, "分享到朋友圈", TAG_SHARE_WECHAT_MOMENT, BottomSheetDialog.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_weibo, "分享到微博", TAG_SHARE_WEIBO, BottomSheetDialog.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_chat, "分享到私信", TAG_SHARE_CHAT, BottomSheetDialog.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_save, "保存到本地", TAG_SHARE_LOCAL, BottomSheetDialog.BottomGridSheetBuilder.SECOND_LINE)
                .setOnSheetItemClickListener(new BottomSheetDialog.BottomGridSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(BottomSheetDialog dialog, View itemView) {
                        dialog.dismiss();
                        int tag = (int) itemView.getTag();
                        switch (tag) {
                            case TAG_SHARE_WECHAT_FRIEND:
                                Toast.makeText(mContext, "分享到微信", Toast.LENGTH_SHORT).show();
                                break;
                            case TAG_SHARE_WECHAT_MOMENT:
                                Toast.makeText(mContext, "分享到朋友圈", Toast.LENGTH_SHORT).show();
                                break;
                            case TAG_SHARE_WEIBO:
                                Toast.makeText(mContext, "分享到微博", Toast.LENGTH_SHORT).show();
                                break;
                            case TAG_SHARE_CHAT:
                                Toast.makeText(mContext, "分享到私信", Toast.LENGTH_SHORT).show();
                                break;
                            case TAG_SHARE_LOCAL:
                                Toast.makeText(mContext, "保存到本地", Toast.LENGTH_SHORT).show();
                                break;

                            default:
                                break;
                        }
                    }
                }).build().show();
    }
}
