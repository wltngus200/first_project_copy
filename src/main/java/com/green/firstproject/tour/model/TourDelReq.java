package com.green.firstproject.tour.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class TourDelReq {
    @Schema(name = "tour_id")
    private long tourId;
    @Schema(name = "signed_user_id")
    private long signedUserId;
    @ConstructorProperties("{tour_id, signed_user_id}")
    public TourDelReq(long tourId, long signedUserId) {
        this.tourId = tourId;
        this.signedUserId = signedUserId;
    }
}
