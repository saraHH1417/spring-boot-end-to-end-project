package com.sara.datingapi.exceptions;

import java.util.Date;

public class UserAccountExceptionResponse {
    private String errorMessage, description;
    private Date dateAndTime;

   public UserAccountExceptionResponse(String errorMessage,
                                       String description,
                                       Date dateAndTime) {
        this.errorMessage = errorMessage;
        this.description = description;
        this.dateAndTime = dateAndTime;
   }
}
