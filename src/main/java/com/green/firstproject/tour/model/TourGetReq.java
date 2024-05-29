package com.green.firstproject.tour.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class TourGetReq {
    private long signedUserId;
    private String startDate;
    private String endDate;
    @ConstructorProperties("{signed_user_id, start_date, end_date}")
    public TourGetReq(long signedUserId, String startDate, String endDate) {
        this.signedUserId = signedUserId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
