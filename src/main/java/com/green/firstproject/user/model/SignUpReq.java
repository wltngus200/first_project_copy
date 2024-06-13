package com.green.firstproject.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class SignUpReq {
    @JsonIgnore
    private long userId;

    private String uid;
    private String upw;
    private String nm;
    private String email;

}
