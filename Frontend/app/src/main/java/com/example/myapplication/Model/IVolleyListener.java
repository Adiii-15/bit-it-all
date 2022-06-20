package com.example.myapplication.Model;

import com.android.volley.VolleyError;


public interface IVolleyListener {
    /**
     * Interface to set success message as needed
     * @param s
     */
    public void onSuccess(String s);

    /**
     * Interface to set error message as needed
     * @param s
     */
    public void onError(VolleyError s);
}
