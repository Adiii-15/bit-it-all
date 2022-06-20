package com.example.myapplication;

import android.content.Context;

import com.example.myapplication.Model.VolleyHandler;
import com.example.myapplication.Presenter.Presenter;
import com.example.myapplication.View.TestingView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;

import org.mockito.junit.MockitoRule;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import androidx.test.platform.app.InstrumentationRegistry;


import org.mockito.runners.MockitoJUnitRunner;

import com.example.myapplication.Model.VolleyHandler;
import com.example.myapplication.Presenter.Presenter;
import com.example.myapplication.View.LoginActivity;
import com.example.myapplication.View.TestingView;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ExampleInstrumentedTest {

    @Mock
    private Context context;

    @Mock
    private TestingView view;

    @Mock
    private VolleyHandler volleyHandler;

    @Test
    public void Success_case(){
        String username="aditi";
        String password="aditi";

        Presenter presenter = new Presenter(view, context);
        presenter.setModel(volleyHandler);
        presenter.login(username, password);
        assertEquals(presenter.result(),"1");



    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myapplication", appContext.getPackageName());
    }
}