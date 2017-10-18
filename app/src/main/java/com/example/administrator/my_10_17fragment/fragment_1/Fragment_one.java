package com.example.administrator.my_10_17fragment.fragment_1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.my_10_17fragment.R;
import com.example.administrator.my_10_17fragment.adapter.RecyAdapter;
import com.example.administrator.my_10_17fragment.bean.Bean;
import com.example.administrator.my_10_17fragment.okhttp.OkhttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/17.
 */

public class Fragment_one extends Fragment {
    private Context context;
    List<Bean.ResultBean.DataBean> list2 = new ArrayList<>();
    private RecyAdapter adapter;
    private RecyclerView recycelrview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.imgitem, null);
        initView(inflate);
        OkhttpUtils.getInstance().setGet("http://v.juhe.cn/toutiao/index?type=top&key=097060266650f67b2cebd2a06aded587", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("TAG",string.toString());
                Gson gson = new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
                list2.addAll(data);
             getActivity().runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                 adapter.notifyDataSetChanged();
                 }
             });

            }
        });

        return inflate;
    }

    private void initView(View inflate) {
        recycelrview = (RecyclerView) inflate.findViewById(R.id.recycelrview);
        adapter = new RecyAdapter(list2,getContext());
        recycelrview.setLayoutManager(new LinearLayoutManager(getContext()));
        recycelrview.setAdapter(adapter);
    }
}
