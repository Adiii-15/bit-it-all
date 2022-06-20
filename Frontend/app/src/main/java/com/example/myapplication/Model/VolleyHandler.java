package com.example.myapplication.Model;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.View.HomepageActivity;
import com.example.myapplication.View.LoginActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * This class handles GET, POST requests
 */
public class VolleyHandler {
    IVolleyListener volleyListener;
    Context context;
    RequestQueue Queue;

    /**
     * Constructor for volley handler to initialize the context with the volley listener
     * @param c
     * @param l
     */
    public VolleyHandler(Context c, IVolleyListener l){
        this.context = c;
        this.volleyListener = l;

    }
    public void register(String name, String username, String password){
        String register_url = "";

    }

    /**
     * Helper method to send request to actual JSON handler
     * @param username
     * @param password
     */
    public void login(String username, String password){
        String url = "https://12a6251c-6c39-4dc6-acb1-b7c9552f8d22.mock.pstmn.io/api/login";
        callServer(username,password, url);
    }


    /**
     * Method to communicate with server address specified by url to post username and password
     * @param username
     * @param password
     * @param url
     */
    public void callServer(final String username, final String password, String url){
          StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                   new com.android.volley.Response.Listener<String>() {
                       @Override
                       public void onResponse(String response) {
                           Log.e("anyText",response);
                           try{
                               JSONObject jsonObject = new JSONObject(response);
                               boolean error = jsonObject.getBoolean("error");
                               String success = jsonObject.getString("success");
                               String message = jsonObject.getString("message");
                               String id= jsonObject.getString("id");
                               String name = jsonObject.getString("name");
                               String username = jsonObject.getString("username");
                               if(message.equals("Success")){
                                   String res = "1";
                                   volleyListener.onSuccess(res);
                               }else{

                               }
                           } catch (Exception e) {
                              e.printStackTrace();

                           }
                       }
                   }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                   volleyListener.onError(error);
               }
           })
           {
               @Override
               protected Map<String, String> getParams() {
                   Map<String,String> params = new HashMap<>();
                   params.put("username",username);
                   params.put("password",password);
                   return params;
               }
           };
         Volley.newRequestQueue(context).add(stringRequest);

   }


}
