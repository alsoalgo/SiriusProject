package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    String TAG = "Adapter";
    private LayoutInflater inflater;
    private ArrayList<Model> imageModelArrayList;


    public Adapter(Context ctx, ArrayList<Model> imageModelArrayList){
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        Log.e(TAG, "Created Adapter");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.iv.setImageResource(R.drawable.bike);
        holder.title.setText(imageModelArrayList.get(position).getTitle());
        holder.shortDesc.setText(imageModelArrayList.get(position).getShortdesc());
        holder.ivLike.setImageResource(R.drawable.like);
        holder.ivDislike.setImageResource(R.drawable.dislike);
        holder.ivComment.setImageResource(R.drawable.comments);
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, shortDesc;
        ImageView iv, ivLike, ivDislike, ivComment;

        public MyViewHolder(View itemView) {
            super(itemView);
            shortDesc = (TextView) itemView.findViewById(R.id.tv2);
            title = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            ivLike = (ImageView) itemView.findViewById(R.id.iv_like);
            ivDislike = (ImageView) itemView.findViewById(R.id.iv_dislike);
            ivComment = (ImageView) itemView.findViewById(R.id.iv_comment);
        }

    }
}

