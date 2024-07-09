package com.Hrm.LoginMicroService.Exception;

public class InvalidTokenException extends Exception {


	
    public InvalidTokenException(String msg) {
        super(msg);
    }

    public InvalidTokenException(String msg, Throwable t) {
        super(msg, t);
    
}
}
