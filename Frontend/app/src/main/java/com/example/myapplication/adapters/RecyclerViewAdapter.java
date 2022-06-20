package com.example.myapplication.adapters;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.Model.JsonData;
import com.example.myapplication.View.ItemsActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<JsonData> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<JsonData> mData){
        this.mContext = mContext;
        this.mData = mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_row_item, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ItemsActivity.class);
                i.putExtra("item_name", mData.get(viewHolder.getAdapterPosition()).getItemname());
                i.putExtra("item_description", mData.get(viewHolder.getAdapterPosition()).getItemDescription());
                i.putExtra("item_photo", mData.get(viewHolder.getAdapterPosition()).getImg_url());
                i.putExtra("item_end_date", mData.get(viewHolder.getAdapterPosition()).getEndDate());
                i.putExtra("item_posted_date", mData.get(viewHolder.getAdapterPosition()).getPostedDate());
                i.putExtra("item_current_price", mData.get(viewHolder.getAdapterPosition()).getCurrentPrice());
                i.putExtra("item_buy_now", mData.get(viewHolder.getAdapterPosition()).getCurrentPrice());

                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemName.setText(mData.get(position).getItemname());
        holder.itemDescription.setText(mData.get(position).getItemDescription());
        Double s = mData.get(position).getCurrentPrice();
        holder.currentPrice.setText(s.toString());
        Double f = mData.get(position).getCurrentPrice();
        holder.buynowPrice.setText(f.toString());

        //glide integration

        Glide.with(mContext).load("https://image.shutterstock.com/image-vector/new-item-vector-lettering-banner-260nw-1927061969.jpg").apply(option).into(holder.itemPic);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView itemDescription;
        TextView currentPrice;
        TextView buynowPrice;
        ImageView itemPic;
        LinearLayout view_container;

        public MyViewHolder(View itemView){
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            itemName = itemView.findViewById(R.id.Item_title);
            itemDescription = itemView.findViewById(R.id.Item_desc);
            currentPrice = itemView.findViewById(R.id.Current_price);
            buynowPrice = itemView.findViewById(R.id.Buy_now_price);
            itemPic = itemView.findViewById(R.id.thumbnail);
        }
    }
}
