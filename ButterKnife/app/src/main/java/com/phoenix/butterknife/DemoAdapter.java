package com.phoenix.butterknife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by flashing on 2016/9/3.
 */
public class DemoAdapter extends BaseAdapter{
    Context mContext;
    int[] drawableId = {R.drawable.car_red, R.drawable.car_black, R.drawable.car_green, R.drawable.car_yellow};
    String[] commentStr = {"豪车啊，二代就是幸福", "明儿就去订车，万事具备，就看今晚的双色球了",
            "这车我一个都不认识啊", "你们城里人真会玩，能带上我么？", "聪哥说：留言就随机抽取送一辆"};

    public DemoAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null != convertView) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_item_friend_news, null);
            viewHolder = new ViewHolder(convertView);
//            convertView.setTag(viewHolder);//在ViewHolder的构造方法中setTag了
        }
        viewHolder.pic_IV.setImageResource(drawableId[new Random().nextInt(4)]);
        viewHolder.comment01_TV.setText(commentStr[new Random().nextInt(5)]);
        viewHolder.comment02_TV.setText(commentStr[new Random().nextInt(5)]);

        return convertView;
    }

    public static class ViewHolder {
        @BindView(R.id.iv_item_friend_news_pic)
        ImageView pic_IV;
        @BindView(R.id.tv_item_friend_news_comment1)
        TextView comment01_TV;
        @BindView(R.id.tv_item_friend_news_comment2)
        TextView comment02_TV;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
