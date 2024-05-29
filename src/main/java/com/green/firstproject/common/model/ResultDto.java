package com.green.firstproject.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto<T>{
    private HttpStatus statusCode;
    private String resultMsg;
    private T result;
}
