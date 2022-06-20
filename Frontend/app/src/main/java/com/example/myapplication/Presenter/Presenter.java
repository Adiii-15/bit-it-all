package com.example.myapplication.Presenter;

import android.content.Context;
import android.content.Intent;

import com.android.volley.VolleyError;
import com.example.myapplication.View.MainActivity;
import com.example.myapplication.Model.IVolleyListener;
import com.example.myapplication.Model.VolleyHandler;
import com.example.myapplication.View.HomepageActivity;
import com.example.myapplication.View.LoginActivity;
import com.example.myapplication.View.TestingView;
import com.example.myapplication.Model.VolleyHandler;
import com.example.myapplication.Presenter.Presenter;
import com.example.myapplication.R;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

/**
 * This class is a presenter class that specifies what needs to be diplayed from model class
 */

public class Presenter implements IVolleyListener {
    private VolleyHandler model;
   private TestingView view;
    private Context context;
    String f;

    /**
     * Constructor to set presenter to given view and context
     * @param view
     * @param c
     */
    public Presenter(TestingView view, Context c) {
        this.view    = view;
        context = c;
        this.model   = new VolleyHandler(c, this);
    }

    /**
     * Sets to given Volley Handler
     * @param m
     */
    public void setModel(VolleyHandler m) { this.model = m;}

    /**
     * Method calls login function from Model class
     * @param username
     * @param password
     */
    public void login(String username, String password){
       // view.showProgressBar();
        model.login(username, password);
    }

    /**
     * Returns result
     * @return
     */
    public String result(){
        return f;
    }

    /**
     * Specifies success message
     * @param s
     */
    @Override
    public void onSuccess(String s) {
        view.hideProgressBar();
        view.updateUserInfoTextView(s);
        f=s.toString();
    }

    /**
     * Specifies error message
     * @param error
     */
    @Override
    public void onError(VolleyError error) {
        try {
            String responseBody = new String(error.networkResponse.data, "utf-8");
            Log.d("TAG", responseBody);
        } catch (UnsupportedEncodingException e){
            Log.d("TAG",e.toString());
        }
    }


}
