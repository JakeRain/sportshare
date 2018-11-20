package com.example.zy.wexinshare.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zy.wexinshare.R;
import com.example.zy.wexinshare.bean.MyCircle;

import java.util.List;

public class CircleListAdapter extends RecyclerView.Adapter<CircleListAdapter.CircleViewHolder> {

    LayoutInflater inflater;
    List<MyCircle> beans;
    Context context;
    public CircleListAdapter(List<MyCircle > beans,Context context) {
        this.beans = beans;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public CircleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.load_item,parent,false);
        return new CircleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CircleViewHolder holder, int position) {
        MyCircle circle = beans.get(position);
        holder.iv.setImageResource(R.drawable.nonepic);
        holder.iv.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),R.drawable.nonepic));
        holder.tv_name.setText(circle.name);
        holder.tv_msg.setText(circle.msg);
        Log.e("onBindViewHolder" ,"数据已经传输到onbindviewholder");

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
            iv = (ImageView) itemView.findViewById(R.id.circle_iv);
            tv_name = (TextView) itemView.findViewById(R.id.circle_name);
            tv_msg = (TextView) itemView.findViewById(R.id.circle_msg);

        }
    }
}
