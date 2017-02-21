package com.phoenix.butterknife;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.iv_activity_main_dog)
    ImageView haske_iv;

    @Nullable
    @BindView(R.id.tv_item_friend_news_comment2)
    TextView optComment_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

//    //不传入控件
//    @OnClick(R.id.tv_activity_main_translation)
//    public void translate(){
//        haske_iv.animate().scaleXBy(0.5f).scaleYBy(0.5f).alphaBy(0.3f).setDuration(2000).start();
//    }

    //传入控件
    @OnClick(R.id.tv_activity_main_translation)
    public void translate(TextView textView){
        haske_iv.animate().scaleXBy(0.5f).scaleYBy(0.5f).alphaBy(0.3f).setDuration(2000).start();
        textView.setText("变形成功");
    }

    @OnClick(R.id.tv_activity_main_goto_next_page)
    public void gotoNextPage(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
