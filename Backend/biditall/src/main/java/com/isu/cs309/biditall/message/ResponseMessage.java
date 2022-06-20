package com.isu.cs309.biditall.message;

import io.swagger.models.Response;

public class ResponseMessage {

    /**
     * instance for a response
     */
    private String response;

    /**
     * contructor declaring an response string
     * @param msg
     */
    public ResponseMessage(String msg)
    {
        response = msg;
    }

    /**
     * return message
     * @return
     */
    public String getMessage()
    {
        return response;
    }

    /**
     * set message
     * @param msg
     */
    public void setMessage(String msg)
    {
        response = msg;
    }
}
