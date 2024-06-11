package com.green.firstproject.common.model;

import org.springframework.http.HttpStatus;

public class ResultSuccess<T> implements Result {
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;
}
