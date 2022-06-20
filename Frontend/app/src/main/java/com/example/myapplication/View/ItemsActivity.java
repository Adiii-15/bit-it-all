package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Date;

public class ItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        //hides default action bar
        getSupportActionBar().hide();

        String name = getIntent().getExtras().getString("item_name");
        String description = getIntent().getExtras().getString("item_description");
        String image = getIntent().getExtras().getString("item_photo");
        String currentPrice = getIntent().getExtras().getString("item_current_price");
        String buyNowPrice = getIntent().getExtras().getString("item_buy_now");
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView i_name = findViewById(R.id.aa_Item_title);
        TextView i_desc = findViewById(R.id.aa_description);
        ImageView i_img = findViewById(R.id.aa_thumbnail);
        TextView i_curr = findViewById(R.id.aa_current_price);
        TextView i_now = findViewById(R.id.aa_buy_now);
        ImageView pic = findViewById(R.id.aa_thumbnail);

        i_name.setText(name);
        i_desc.setText(description);
        i_curr.setText(currentPrice);
        i_now.setText(buyNowPrice);



        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        Glide.with(this).load("https://image.shutterstock.com/image-vector/new-item-vector-lettering-banner-260nw-1927061969.jpg").apply(requestOptions).into(i_img);
    }
}