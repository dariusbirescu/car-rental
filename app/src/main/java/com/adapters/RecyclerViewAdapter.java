package com.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darius.carrental.Car;
import com.example.darius.carrental.CarRentalActivity;
import com.example.darius.carrental.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Car> mData ;


    public RecyclerViewAdapter(Context mContext, List<Car> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_car,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.model.setText(mData.get(position).getModel());
        holder.car_image.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CarRentalActivity.class);

                intent.putExtra("Model",mData.get(position).getModel());
                intent.putExtra("Price",mData.get(position).getPrice());
                intent.putExtra("Year",mData.get(position).getYear());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView model;
        ImageView car_image;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            model = (TextView) itemView.findViewById(R.id.Model) ;
            car_image = (ImageView) itemView.findViewById(R.id.car_img);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
