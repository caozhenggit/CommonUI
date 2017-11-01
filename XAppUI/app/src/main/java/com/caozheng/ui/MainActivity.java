package com.caozheng.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.caozheng.ui.dialog.XTipDialog;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData(){
        String[] listItems = new String[]{
                "Loading 类型提示框",
                "成功提示类型提示框",
                "失败提示类型提示框",
                "信息提示类型提示框",
                "单独文字类型提示框",
                "自定义内容提示框"
        };

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this
                , android.R.layout.simple_list_item_1
                ,  android.R.id.text1
                , listItems);

        mLv.setAdapter(arrayAdapter);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
                XTipDialog tipDialog;
                switch (i) {
                    case 0:
                        tipDialog = new XTipDialog.Builder(MainActivity.this)
                                .setIconType(XTipDialog.Builder.ICON_TYPE_LOADING)
                                .setTipWord("正在加载")
                                .create();
                        break;

                    case 1:
                        tipDialog = new XTipDialog.Builder(MainActivity.this)
                                .setIconType(XTipDialog.Builder.ICON_TYPE_SUCCESS)
                                .setTipWord("正在加载")
                                .create();
                        break;

                    case 2:
                        tipDialog = new XTipDialog.Builder(MainActivity.this)
                                .setIconType(XTipDialog.Builder.ICON_TYPE_FAIL)
                                .setTipWord("正在加载")
                                .create();
                        break;

                    case 3:
                        tipDialog = new XTipDialog.Builder(MainActivity.this)
                                .setIconType(XTipDialog.Builder.ICON_TYPE_INFO)
                                .setTipWord("正在加载")
                                .create();
                        break;

                    case 4:
                        tipDialog = new XTipDialog.Builder(MainActivity.this)
                                .setIconType(XTipDialog.Builder.ICON_TYPE_NOTHING)
                                .setTipWord("正在加载")
                                .create();
                        break;

                    case 5:
                        tipDialog = new XTipDialog.Builder(MainActivity.this)
                                .setIconType(XTipDialog.Builder.ICON_TYPE_LOADING)
                                .setTipWord("正在加载")
                                .create();
                        break;

                    default:
                        tipDialog = new XTipDialog.Builder(MainActivity.this)
                                .setIconType(XTipDialog.Builder.ICON_TYPE_LOADING)
                                .setTipWord("正在加载")
                                .create();
                        break;
                }

                tipDialog.show();
            }
        });
    }
}
