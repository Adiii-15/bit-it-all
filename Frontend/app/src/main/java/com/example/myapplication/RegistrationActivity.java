package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
 EditText name ,l_name,email ,phone,username_i, password_i, dob_i;
 RadioButton buy, sell;
    Button rregister;
    String first_name, last_name,dob, email_id,phone_no, username, pass;
    ProgressDialog pdDialog;
    String URL_REGISTER = "https://enlu5tew9iwkwuk.m.pipedream.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//
      name=(EditText)findViewById(R.id.first_name);
      l_name=(EditText) findViewById(R.id.last_name);
      email = (EditText) findViewById(R.id.email_id);
      phone = (EditText) findViewById(R.id.phone_num);
      username_i = (EditText) findViewById(R.id.input_username);
      password_i = (EditText) findViewById(R.id.input_password);
      dob_i = (EditText) findViewById(R.id.dateof_birth);
      rregister = (Button) findViewById(R.id.button_register);

////        username=(TextInputEditText)findViewById(R.id.rusername);
////        password=(TextInputEditText)findViewById(R.id.rpassword);
////        rregister=(Button) findViewById(R.id.rregister);
////        pdDialog= new ProgressDialog(RegistrationActivity.this);
////        pdDialog.setTitle("Registering please wait...");
////        pdDialog.setCancelable(false);
        rregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first_name = name.getText().toString().trim();
                last_name = l_name.getText().toString().trim();
                email_id = email.getText().toString();
                if(first_name.isEmpty()||last_name.isEmpty())
                {
                    Toast.makeText(RegistrationActivity.this,"please enter valid data",Toast.LENGTH_SHORT).show();
                }
                else{
                    Register();
                }
            }
        });
    }
    private void Register()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("anyText",response);
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            String message = jsonObject.getString("message");
                       //     if(success.equals(Htts)){
                                Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_LONG).show();
                                pdDialog.dismiss();
                                finish();

//                            else {
//                                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
//                                pdDialog.dismiss();
//                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Registration Error !1"+e,Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pdDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Registration Error !2"+error,Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> params = new HashMap<>();
                Map<String,String> ps = new HashMap<>();
                params.put("firstName",name.getText().toString().trim());
                params.put("lastName",l_name.getText().toString().trim());
                params.put("email",email.getText().toString());
                params.put("phoneNumber",phone.getText().toString());
                params.put("dob", dob_i.getText().toString());
               ps.put("username",username_i.getText().toString());
               ps.put("password",password_i.getText().toString());
               params.putAll(ps);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}