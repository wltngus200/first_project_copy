package com.green.firstproject.tour.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class TourGetReq {
    @Schema(name = "signed_user_id")
    private long signedUserId;
    //private String startDate;
    //private String endDate;
    @ConstructorProperties({"signed_user_id"})
    public TourGetReq(long signedUserId) {
        this.signedUserId = signedUserId;
        //this.startDate = startDate;
        //this.endDate = endDate;
    }
}
