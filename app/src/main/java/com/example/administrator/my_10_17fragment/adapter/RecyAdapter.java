package com.example.administrator.my_10_17fragment.adapter;


import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.my_10_17fragment.R;
import com.example.administrator.my_10_17fragment.bean.Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    List<Bean.ResultBean.DataBean> list2;
    private Context context;

    public RecyAdapter(List<Bean.ResultBean.DataBean> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textview.setText(list2.get(position).getTitle());
        Glide.with(context).load(list2.get(position).getThumbnail_pic_s());

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textview;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.textview);
            img = (ImageView) itemView.findViewById(R.id.img);

        }
    }
}
