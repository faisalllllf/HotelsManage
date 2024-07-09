package com.Hrm.LoginMicroService.Exception;

public class UserNotFoundException extends Exception {

	
    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(String msg, Throwable t) {
        super(msg, t);
    
}
}
