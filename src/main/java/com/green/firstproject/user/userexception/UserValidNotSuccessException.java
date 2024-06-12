package com.green.firstproject.user.userexception;

public class UserValidNotSuccessException extends RuntimeException {
    public UserValidNotSuccessException() {super();}
    public UserValidNotSuccessException(String message) {super(message);}
    public UserValidNotSuccessException(String message, Throwable cause) {super(message, cause);}
    public UserValidNotSuccessException(Throwable cause) {super(cause);}
}
