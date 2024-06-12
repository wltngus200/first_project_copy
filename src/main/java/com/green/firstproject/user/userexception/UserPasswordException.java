package com.green.firstproject.user.userexception;

public class UserPasswordException extends RuntimeException {
    public UserPasswordException() {super();}
    public UserPasswordException(String message) {super(message);}
    public UserPasswordException(String message, Throwable cause) {super(message, cause);}
    public UserPasswordException(Throwable cause) {super(cause);}
}
