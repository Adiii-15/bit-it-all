package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Add_item extends AppCompatActivity {
    private EditText usernameEdt, passwordEdt;
    private Button postDataBtn, getPostDataBtn;
    private TextView responseTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        usernameEdt = findViewById(R.id.editTextTextPersonName);
        passwordEdt = findViewById(R.id.editTextTextPersonName2);
        postDataBtn = findViewById(R.id.button);

        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postItemData();
            }
        });

    }
    public void postItemData(){
        String url = "http://coms-309-038.cs.iastate.edu:8080/api/item";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            object.put("item_name",usernameEdt.getText().toString());
            object.put("item_description",passwordEdt.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Enter the correct url for your api service site

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        responseTV.setText("String Response : "+ response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseTV.setText("sucessful registeration");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}