package com.example.darius.carrental;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter {

    private Context mContext;

    private List<Upload> muploads;

    public ImageAdapter(Context context, List<Upload> uploads)
    {
        muploads=uploads;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.image_item,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Upload uploadCurrent=muploads.get(position);
        ImageViewHolder imageViewHolder=(ImageViewHolder) holder;
        imageViewHolder.textViewName.setText(uploadCurrent.getmName());
        Uri uri =  Uri.parse(uploadCurrent.getmImageUrl());
        imageViewHolder.imageView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return muploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imageView;



        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName=itemView.findViewById(R.id.text_view_name);
            imageView=itemView.findViewById(R.id.image_view_id);
        }
    }
}
