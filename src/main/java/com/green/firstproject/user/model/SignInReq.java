package com.green.firstproject.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignInReq {
    private String uid;
    private String upw;
}
