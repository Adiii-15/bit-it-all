package com.example.myapplication.View;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.Model.IVolleyListener;
import com.example.myapplication.Model.VolleyHandler;
import com.example.myapplication.Presenter.Presenter;
import com.example.myapplication.R;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.example.myapplication.RegistrationActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity{
    TextView Registernow, errorWindow;
    ProgressDialog pdDialog;
    String URL_LOGIN = "https://12a6251c-6c39-4dc6-acb1-b7c9552f8d22.mock.pstmn.io/api/login";
    EditText username, password;

    Button loginButton;
    String is_signed_in = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Registernow = (Button) findViewById(R.id.registernow);

        username = (EditText) findViewById(R.id.lusername);
        password = (EditText) findViewById(R.id.lpassword);
        loginButton = (Button) findViewById(R.id.loginbutton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    Registernow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), RegistrationActivity.class);
            startActivity(i);
        }
    });
    }

private void login(){
    String url = "http://coms-309-038.cs.iastate.edu:8080/secure";
    String input_username = username.getText().toString().trim();
    String input_password= password.getText().toString().trim();
    System.out.println(input_password);
    System.out.println(input_username);
    if(!input_username.equals("")||!input_password.equals("")){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                if (response.equals("Secured Link")) {
                    Toast.makeText(LoginActivity.this, "Succesful login", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(getApplicationContext(),HomepageActivity.class);
                      intent.putExtra("username", input_username);
                        startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Login Id/Password", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.toString().trim(), Toast.LENGTH_LONG).show();
                System.out.println(error.toString().trim());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                HashMap<String, String> params = new HashMap<String, String>();

                String creds = String.format("%s:%s",input_username,input_password);
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.NO_WRAP);
                params.put("Authorization", auth);
                return params;
//                String credentials =input_username;
//                String auth = "Basic Z2xIZWI6ZHVtbXk=";
//                Map<String, String> params = new HashMap<String, String>();
//           //   params.put("Content-Type", "application/json");
////               params.put("Accept", "*/*");
////               params.put("Accept-Encoding","gzip, deflate, br");
//            params.put("Host", "coms-309-038.cs.iastate.edu:8080");
////               params.put("Connection", "keep-alive");
//               params.put("Authorization",auth );
//     //           params.put("Content-Type","text/plain;charset=UTF-8");
               // return params;
            }
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> data = new HashMap<>();
                data.put("username", input_username);
                data.put("password", input_password);
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
}