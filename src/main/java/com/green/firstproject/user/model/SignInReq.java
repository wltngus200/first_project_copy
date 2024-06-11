package com.green.firstproject.user.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInReq {
    private String uid;
    private String upw;
}
