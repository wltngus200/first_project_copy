package com.green.firstproject.user.userexception;

public class UserEmailException extends RuntimeException {
    public UserEmailException() {super();}
    public UserEmailException(String message) {super(message);}
    public UserEmailException(String message, Throwable cause) {super(message, cause);}
    public UserEmailException(Throwable cause) {super(cause);}
}
