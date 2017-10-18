package com.example.administrator.my_10_17fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.administrator.my_10_17fragment.R;

/**
 * Created by Administrator on 2017/10/17.
 */

public class Fragment_fu extends Fragment {
    private WebView webview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fu_item, container,false);

        initView(inflate);
        webview.loadUrl("http://blog.csdn.net/fancylovejava/article/details/44747759");
        return inflate;
    }

    private void initView(View inflate) {
        webview = (WebView) inflate.findViewById(R.id.webview);
    }
}
