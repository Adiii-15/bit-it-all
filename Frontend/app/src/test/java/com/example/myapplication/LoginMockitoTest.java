package com.example.myapplication;

import org.junit.Rule;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import android.os.AsyncTask;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.example.myapplication.Model.JsonData;
import com.example.myapplication.View.LoginActivity;
import com.example.myapplication.View.MainActivity;

public class LoginMockitoTest {


    @Test
    public void userPassValid(){
        JsonData p = Mockito.mock(JsonData.class);
        p.setItemDescription("Hello world");
        String b = p.getItemDescription();
        Assert.assertEquals("Hello world", b);
        LoginActivity a = Mockito.mock(LoginActivity.class);
    }
}
