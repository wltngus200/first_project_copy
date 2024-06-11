package com.green.firstproject.user.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInReq {
    private String uid;
    private String upw;
}
