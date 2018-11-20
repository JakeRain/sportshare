package com.example.zy.wexinshare.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.zy.wexinshare.R;
import com.example.zy.wexinshare.config.GeneralConfig;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    public final String[] imageUrls = new String[]{"uploadDir/img/_20181114113049.jpg",
            "uploadDir/img/微信图片_201811141130491.jpg","uploadDir/img/微信图片_2018111411304910.jpg",
            "uploadDir/img/微信图片_201811141130492.jpg","uploadDir/img/微信图片_201811141130493.jpg",
            "uploadDir/img/微信图片_201811141130494.jpg","uploadDir/img/微信图片_201811141130495.jpg",
            "uploadDir/img/微信图片_201811141130496.jpg","uploadDir/img/微信图片_201811141130497.jpg",
            "uploadDir/img/微信图片_201811141130498.jpg","uploadDir/img/微信图片_201811141130499.jpg"};

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = inflater.inflate(R.layout.load_item, parent, false);//单个item的布局
        return new MyViewHolder(inflate);
    }

    @Override
    public int getItemCount() {
        return imageUrls.length;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.textView.setText("风景" + position);
        //用了Glide加载图片，这是一款不错的图片加载框架，毕竟属于Google亲儿子了吧，不会用的也可以用picasso，这个框架参考picasso的，基本跟picasso一模一样。
        Glide.with(context)
                .load(GeneralConfig.URL_HOST+imageUrls[position])
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)//这里设置了不做任何缓存
                .placeholder(R.drawable.nonepic)//这是占位图。加载图片的一瞬间可以用来填充，万一网络不行还可以有个好的视觉效果。毕竟什么都不显示让人很绝望呀。。。
                .into(new BitmapImageViewTarget(holder.imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        //这里用来进行图片转换，转成圆形的图。
                        RoundedBitmapDrawable circleBitmap = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circleBitmap.setCircular(false);
                        holder.imageView.setImageDrawable(circleBitmap);
                    }
                });
        //这里就是让我们最终的效果跟Gridview不同的原因了，我们把第一列和第三列的首张图片设置距离顶部一个距离，这样布局错落有致，就是我们要的效果了
        if (position == 0 || position == 2) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(holder.imageView.getLayoutParams());
            lp.setMargins(0, 100, 0, 0);
            holder.imageView.setLayoutParams(lp);
        } else {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(holder.imageView.getLayoutParams());
            lp.setMargins(0, 0, 0, 0);
            holder.imageView.setLayoutParams(lp);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.circle_iv);
            textView = (TextView) itemView.findViewById(R.id.circle_name);
        }
    }
}