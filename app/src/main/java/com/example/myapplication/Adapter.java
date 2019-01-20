package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.net.URI;
import java.util.ArrayList;
import java.util.concurrent.ExecutorCompletionService;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Model> imageModelArrayList;


    public Adapter(Context ctx, ArrayList<Model> imageModelArrayList){
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        try {
            holder.iv.setImageResource(imageModelArrayList.get(position).getId());
            holder.time.setText(imageModelArrayList.get(position).getTitle());
            holder.text.setText(imageModelArrayList.get(position).getShortdesc());
            holder.ivLike.setImageResource(R.drawable.like);
            holder.ivDislike.setImageResource(R.drawable.dislike);
            holder.ivComment.setImageResource(R.drawable.comments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time, text;
        ImageView iv, ivLike, ivDislike, ivComment;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.text = (TextView) itemView.findViewById(R.id.tv2);
            this.time = (TextView) itemView.findViewById(R.id.tv);
            this.iv = (ImageView) itemView.findViewById(R.id.iv);
            this.ivLike = (ImageView) itemView.findViewById(R.id.iv_like);
            this.ivDislike = (ImageView) itemView.findViewById(R.id.iv_dislike);
            this.ivComment = (ImageView) itemView.findViewById(R.id.iv_comment);
        }

    }
}

