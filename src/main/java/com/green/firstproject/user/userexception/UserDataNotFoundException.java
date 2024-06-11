package com.green.firstproject.user.userexception;

public class UserDataNotFoundException extends Exception {
    public UserDataNotFoundException() {super();}
    public UserDataNotFoundException(String message) {super(message);}
    public UserDataNotFoundException(String message, Throwable cause) {super(message, cause);}
    public UserDataNotFoundException(Throwable cause) {super(cause);}
}
