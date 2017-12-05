package com.caozheng.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author caozheng
 * Created time on 2017/11/1
 *
 * description:
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lv)
    ListView mLv;

    private String[] listItems = new String[]{
            "闪屏页",
            "提示类对话框",
            "底部对话框",
            "无限循环viewpager",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this
                , android.R.layout.simple_list_item_1
                ,  android.R.id.text1
                , listItems);

        mLv.setAdapter(arrayAdapter);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, SplashActivity.class));
                        break;

                    case 1:
                        startActivity(new Intent(MainActivity.this, TipDialogActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(MainActivity.this, BottomSheetDialogActivity.class));
                        break;

                    case 3:
                        startActivity(new Intent(MainActivity.this, LoopViewPagerActivity.class));
                        break;

                    default:

                        break;
                }
            }
        });
    }
}
