package com.example.administrator.my_10_17fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.administrator.my_10_17fragment.bean.Bean;
import com.example.administrator.my_10_17fragment.fragment.Fragment_fu;
import com.example.administrator.my_10_17fragment.fragment.Fragment_zhu;
import com.example.administrator.my_10_17fragment.okhttp.OkhttpUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private RadioButton Rbutton;
    private RadioButton Rbutton_two;
    private RadioGroup radioGroup;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        intdata();
        initFrag();
    }

    private void initFrag() {
        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        FragmentTransaction transaction = fragmentTransaction.add(R.id.fl, new Fragment_zhu());
        transaction.commit();
    }


    private void intdata() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.Rbutton:
                        supportFragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragment = supportFragmentManager.beginTransaction();
                        FragmentTransaction replace = fragment.replace(R.id.fl, new Fragment_zhu());
                        replace.commit();
                        break;
                    case R.id.Rbutton_two:
                        supportFragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragment1 = supportFragmentManager.beginTransaction();
                        FragmentTransaction replace1 = fragment1.replace(R.id.fl, new Fragment_fu());
                        replace1.commit();
                        break;
                }
            }
        });

    }

    private void initView() {
        Rbutton = (RadioButton) findViewById(R.id.Rbutton);
        Rbutton_two = (RadioButton) findViewById(R.id.Rbutton_two);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

    }


}
