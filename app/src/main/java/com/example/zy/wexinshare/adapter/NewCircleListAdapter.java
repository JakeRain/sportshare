package com.example.zy.wexinshare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zy.wexinshare.R;
import com.example.zy.wexinshare.bean.MyCricleEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/11/20.
 */

public class NewCircleListAdapter extends RecyclerView.Adapter<NewCircleListAdapter.NewCircleViewHolder> {

    LayoutInflater inflater;
    List<MyCricleEntity.SportBean> beans;
    Context context;
    public NewCircleListAdapter(List<MyCricleEntity.SportBean> beans, Context context) {
        this.beans = beans;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public NewCircleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.load_item,parent,false);
        return new NewCircleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewCircleViewHolder holder, int position) {
        holder.iv.setImageResource(R.drawable.thumb);
        holder.tv_name.setText(beans.get(position).getName());
        holder.tv_msg.setText(beans.get(position).getMsg());
        Log.e("onBindViewHolder" ,"数据已经传输到onbindviewholder");

    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

   static class NewCircleViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv_name;
        TextView tv_msg;
        public NewCircleViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.circle_iv);
            tv_name = (TextView) itemView.findViewById(R.id.circle_name);
            tv_msg = (TextView) itemView.findViewById(R.id.circle_msg);

        }
    }
}
