package com.phoenix.toolbar.weiget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.phoenix.toolbar.R;

/**
 * Created by flashing on 2016/6/10.
 */
public class ZYNToolbar extends Toolbar {
    private View mView;
    private EditText mSearchView;
    private TextView mTextTitle;
    private ImageButton mLeftImageButton;
    private ImageButton mRightImageButton;
    private LayoutInflater mInflater;

    public ZYNToolbar(Context context) {
        this(context, null);
    }

    public ZYNToolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZYNToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
        setContentInsetsRelative(10, 10);

        if(attrs != null) {
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    R.styleable.ZYNToolbar, defStyleAttr, 0);

            final Drawable leftIcon = a.getDrawable(R.styleable.ZYNToolbar_leftButtonIcon);
            if (leftIcon != null) {
                setLeftButtonIcon(leftIcon);
            }

            final Drawable rightIcon = a.getDrawable(R.styleable.ZYNToolbar_rightButtonIcon);
            if (rightIcon != null) {
                setRightButtonIcon(rightIcon);
            }

            boolean isShowSearchView = a.getBoolean(R.styleable.ZYNToolbar_isShowSearchView, false);
            if(isShowSearchView){
                showSearchView();
                hideTitleView();
            }

            a.recycle();
        }
    }

    private void initView() {
        if(mView == null) {
            mInflater = LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.toolbar, null);

            mTextTitle = (TextView) mView.findViewById(R.id.toolbar_title);
            mSearchView = (EditText) mView.findViewById(R.id.toolbar_searchview);
            mLeftImageButton = (ImageButton) mView.findViewById(R.id.toolbar_leftButton);
            mRightImageButton = (ImageButton) mView.findViewById(R.id.toolbar_rightButton);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);
        }
    }

    private void setLeftButtonIcon(Drawable icon) {
        if(mLeftImageButton != null){
            mLeftImageButton.setImageDrawable(icon);
            mLeftImageButton.setVisibility(VISIBLE);
        }
    }

    private void setRightButtonIcon(Drawable icon) {
        if(mRightImageButton != null){
            mRightImageButton.setImageDrawable(icon);
            mRightImageButton.setVisibility(VISIBLE);
        }
    }

    public void setLeftButtonClickListener(OnClickListener listener){
        mLeftImageButton.setOnClickListener(listener);
    }

    public void setRightButtonClickListener(OnClickListener listener){
        mRightImageButton.setOnClickListener(listener);
    }

    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if(mTextTitle != null){
            mTextTitle.setText(title);
            showTitleView();
        }
    }

    public  void showSearchView(){
        if(mSearchView != null){
            mSearchView.setVisibility(VISIBLE);
        }
    }

    public  void hideSearchView(){
        if(mSearchView != null){
            mSearchView.setVisibility(GONE);
        }
    }

    public  void showTitleView(){
        if(mTextTitle != null){
            mTextTitle.setVisibility(VISIBLE);
        }
    }

    public  void hideTitleView(){
        if(mTextTitle != null){
            mTextTitle.setVisibility(GONE);
        }
    }
}
