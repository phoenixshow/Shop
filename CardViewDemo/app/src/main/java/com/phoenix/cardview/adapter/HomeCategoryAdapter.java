package com.phoenix.cardview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phoenix.cardview.R;
import com.phoenix.cardview.bean.HomeCategory;

import java.util.List;

/**
 * Created by flashing on 2016/6/11.
 */
public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.ViewHolder>{
    private static int VIEW_TYPE_L = 0;
    private static int VIEW_TYPE_R = 1;
    private LayoutInflater mInflater;
    private List<HomeCategory> mDatas;

    public HomeCategoryAdapter(List<HomeCategory> datas) {
        this.mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        if(viewType == VIEW_TYPE_R){
            return new ViewHolder(mInflater.inflate(R.layout.template_home_cardview2, parent, false));
        }
        return new ViewHolder(mInflater.inflate(R.layout.template_home_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HomeCategory category = mDatas.get(position);
        holder.textTitle.setText(category.getName());
        holder.imageViewBig.setImageResource(category.getImgBig());
        holder.imageViewSmallTop.setImageResource(category.getImgSmallTop());
        holder.imageViewSmallBottom.setImageResource(category.getImgSmallBottom());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return VIEW_TYPE_R;
        }else{
            return VIEW_TYPE_L;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        ImageView imageViewBig;
        ImageView imageViewSmallTop;
        ImageView imageViewSmallBottom;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView)itemView.findViewById(R.id.text_title);
            imageViewBig = (ImageView)itemView.findViewById(R.id.imgview_big);
            imageViewSmallTop = (ImageView)itemView.findViewById(R.id.imgview_small_top);
            imageViewSmallBottom = (ImageView)itemView.findViewById(R.id.imgview_small_bottom);
        }
    }
}
