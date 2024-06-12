package com.green.firstproject.user.check;

public class Validator {
private static final String ID_REGEX = "^[a-zA-Z0-9]{6,12}$";   // 6~12 글자 영문 대소문자 숫자 0~9 만 가능
    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d|.*[!@#$%^&*()\\\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,20}$"; //영문 8~20 글자, 특수문자 1개이상 포함, 숫자포함
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9]{8,12}@[a-z]{3,5}\\.(com|net|org){1}$";

    public static boolean isValidEmail(String email) { //Email Validation
        return email.matches(EMAIL_REGEX);

    }
    public static boolean isValidPassword(String password) { // Password Validation
        return password.matches(PASSWORD_REGEX);
    }
    public static boolean isValidId(String id) { //Id Validation
        return id.matches(ID_REGEX);
    }
}
