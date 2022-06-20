package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // creating variables for our edittext,
    // button, textview and progressbar.
    private EditText usernameEdt, passwordEdt;
    private Button postDataBtn, getPostDataBtn, itemsbtn;
    private TextView responseTV;
    private ProgressBar loadingPB;
    private String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing our views
        usernameEdt = findViewById(R.id.idEdtName);
        passwordEdt = findViewById(R.id.editTextPassword);
        postDataBtn = (Button) findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);
        getPostDataBtn = findViewById(R.id.getButton);
        postDataBtn.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == postDataBtn){
            login();
        }
    }

    private void login(){
        String url = "http://coms-309-038.cs.iastate.edu:8080/api/login";
        email = usernameEdt.toString().trim();
        password = passwordEdt.toString().trim();
        if(!email.equals("")||!password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("success")) {
                      //  Intent intent = new Intent(this,Homepage.this);
                   //     startActivity(intent);
                  //      finish;
                        Toast.makeText(MainActivity.this, "Valid", Toast.LENGTH_SHORT).show();
                    } else if (response.equals("failure")) {
                        Toast.makeText(MainActivity.this, "Invalid Login Id/Password", Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, error.toString().trim(), Toast.LENGTH_LONG).show();
                }
            }){
                @Override
                protected Map<String,String> getParams() throws AuthFailureError{
                    Map<String,String> data = new HashMap<>();
                    data.put("username", email);
                    data.put("password", password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
else{
    Toast.makeText(this, "Error",Toast.LENGTH_LONG).show();
        }
    }
    private void sendGetRequest() {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://coms-309-038.cs.iastate.edu:8080/api/login";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                responseTV.setText("Data" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                responseTV.setText("Data" + error);
            }
        });
        queue.add(stringRequest);
    }
    public void postData() {
        String url = "http://coms-309-038.cs.iastate.edu:8080/api/login";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            object.put("username",usernameEdt.getText().toString());
            object.put("password",passwordEdt.getText().toString());
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


