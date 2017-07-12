package com.example.caoyang.recyclerviewdemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.caoyang.recyclerviewdemo.NameBean;
import com.example.caoyang.recyclerviewdemo.R;
import com.example.caoyang.recyclerviewdemo.bean.Newsbean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by caoyang on 2017/7/11.
 */

public class MyNewsAdapter extends RecyclerView.Adapter<MyNewsAdapter.NewsAdapter> {
    Context context;
    List<Newsbean.DataBean.ComingBean> list;



    public MyNewsAdapter(Context context, List<Newsbean.DataBean.ComingBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public NewsAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_news, null);
        NewsAdapter newsAdapter = new NewsAdapter(view);
        return newsAdapter;
    }

    @Override
    public void onBindViewHolder(final NewsAdapter holder, int position) {
        holder.tvName.setText(list.get(position).getNm()); //电影名称
        holder.tvGuanzhongNum.setText(String.valueOf(list.get(position).getSc()));
        holder.tvZhuanyeNum.setText(String.valueOf(list.get(position).getMk()));
        holder.zhuyan.setText(list.get(position).getDesc());//主演
        holder.tvDesc.setText(list.get(position).getScm());
        holder.tvInfo.setText(list.get(position).getCat());
        holder.tvTime.setText(list.get(position).getShowInfo());

        holder.videoView.setUp(list.get(position).getVideourl(), JCVideoPlayer.SCREEN_LAYOUT_LIST,"");

        String img = list.get(position).getImg();
        String newImagUrl = img.replaceAll("w.h", "240.260");
//        holder.videoView.thumbImageView("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");

        Glide.with(context).load(newImagUrl).into(holder.videoView.thumbImageView);

        if (holder.videoView != null) {
            holder.videoView.release();
        }




    }



    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class NewsAdapter extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_icon)
        JCVideoPlayerStandard videoView;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_guanzhong_num)
        TextView tvGuanzhongNum;
        @Bind(R.id.tv_zhuanye_num)
        TextView tvZhuanyeNum;
        @Bind(R.id.tv_desc)
        TextView tvDesc;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.zhuyan)
        TextView zhuyan;
        @Bind(R.id.tv_info)
        TextView tvInfo;

        public NewsAdapter(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
