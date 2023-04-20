package com.rodolpho.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timestamps;
    private String message;
    private String details;

    public ErrorDetails(Date timestamps, String message, String details) {
        this.timestamps = timestamps;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamps(){
        
        return this.timestamps;
    }

    public String getMessage(){

        return this.message;
    }

    public String getDetails(){

        return this.details;
    }
}
