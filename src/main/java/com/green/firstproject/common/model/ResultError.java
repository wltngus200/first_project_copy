package com.green.firstproject.common.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
/**
 *
 *
 *
 * */
public class ResultError implements Result {
    private int statusCode;
    private String resultMsg;
}
