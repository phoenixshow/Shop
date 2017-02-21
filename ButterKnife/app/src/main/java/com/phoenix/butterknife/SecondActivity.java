package com.phoenix.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    public static class PlaceholderFragment extends Fragment{
        @BindView(R.id.lv_fragment_second)
        ListView main_lv;

        public PlaceholderFragment(){}

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_second, container, false);
            ButterKnife.bind(this, rootView);
            DemoAdapter adapter = new DemoAdapter(getActivity());
            main_lv.setAdapter(adapter);
            return rootView;
        }

        @OnClick(R.id.iv_fragment_second_back)
        public void finishActivity(){
            getActivity().finish();
        }
    }
}
