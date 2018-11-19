package com.example.zy.wexinshare.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zy.wexinshare.R;
import com.example.zy.wexinshare.bean.MyCircle;

import java.util.List;

public class CircleListAdapter extends RecyclerView.Adapter<CircleListAdapter.CircleViewHolder> {

    List<MyCircle> beans;
    public CircleListAdapter(List<MyCircle > beans) {
        this.beans = beans;
    }

    public void setBeans(List<MyCircle> beans){
        this.beans = beans;
    }


    @Override
    public CircleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_item,parent,false);
        CircleViewHolder holer = new CircleViewHolder(view);
        return holer;
    }

    @Override
    public void onBindViewHolder(CircleViewHolder holder, int position) {
        MyCircle circle = beans.get(position);
        holder.iv.setImageResource(R.drawable.nonepic);
        holder.tv_name.setText(circle.name);
        holder.tv_msg.setText(circle.msg);
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    static class CircleViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv_name;
        TextView tv_msg;
        public CircleViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.circle_iv);
            tv_name = itemView.findViewById(R.id.circle_name);
            tv_msg = itemView.findViewById(R.id.circle_msg);

        }
    }
}
