package com.green.firstproject.common.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@Builder
public class ResultSuccess<T> implements Result {
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;
}
