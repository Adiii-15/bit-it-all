package com.example.myapplication.View;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.myapplication.Model.JsonData;
import com.example.myapplication.R;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.SettingActivity;
import com.example.myapplication.adapters.RecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomepageActivity extends AppCompatActivity {
    //"http://coms-309-038.cs.iastate.edu:8080/api/item/list/1";
    //https://run.mocky.io/v3/256efcb2-ac46-44e1-a368-1b8753f71150
    private String JSON_URL = "https://enlu5tew9iwkwuk.m.pipedream.net";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<JsonData> userList;
    private RecyclerView recyclerView;
    private String userID;
    public  String logged_in_username="";
    Button ae;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Intent intent = getIntent();
      logged_in_username=intent.getStringExtra("username");
        userList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
       // ae = findViewById(R.id.button_refresh);
       jsonrequest();
       getuserID();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.HomePage:
                        return true;
                    case R.id.AddItem:
                        Intent s = new Intent(HomepageActivity.this, AddItemActivity.class);
                        s.putExtra("username", logged_in_username);
                        startActivity(s);
                        return true;

                    case R.id.Settings:
                        startActivity(new Intent(HomepageActivity.this, SettingActivity.class));
                        return true;

                    case R.id.Profile:
                        startActivity(new Intent(HomepageActivity.this, MyProfileActivity.class));
                        return true;
                }
                return false;
            }
        });

    }

    private void getuserID(){
        //http://coms-309-038.cs.iastate.edu:8080/api/item/listAl
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://enlu5tew9iwkwuk.m.pipedream.net", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response.toString();
                userID = s;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(HomepageActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", logged_in_username);
                return params;

            }
        };
        RequestQueue req = Volley.newRequestQueue(HomepageActivity.this);
        req.add(stringRequest);

    }
    private void jsonrequest(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://coms-309-038.cs.iastate.edu:8080/api/item/listAll", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i< response.length(); i++){

                    try{
                        JsonData item = new JsonData();
                        JSONObject person = response.getJSONObject(i);
                        item.setItemname(person.getString("itemName"));
                        item.setItemDescription(person.getString("description"));
                        //      item.setImg_url(jsonObject.getString("img"));
                        String str = person.getString("endDate");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                     //   Date endDate = sdf.parse(str);
                        //      item.setEndDate(endDate);
                        String str1 = person.getString("postedDate");
                      //  Date endDate1 = sdf.parse(str1);
                        //    item.setPostedDate(endDate1);
                        item.setCurrentPrice(person.getDouble("bidPrice"));
                        item.setBuyNowPrice(person.getDouble("buyNowPrice"));
                        userList.add(item);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(userList);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG);
        }
    });
    requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }

    private void setuprecyclerview(List<JsonData> userList) {
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,userList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myadapter);
    }
}
