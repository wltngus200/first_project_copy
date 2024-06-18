package com.green.firstproject.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class ChangeUpwReq {
    private String uid;
    private String upw;
    private String newPw;

}
