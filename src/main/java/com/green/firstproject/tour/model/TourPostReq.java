package com.green.firstproject.tour.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourPostReq {
    @JsonIgnore
    private long tourId;
    private long userId;
    private String title;
    private String tourLocation;
    private String tourStartDay;
    private String tourFinishDay;
    private long tourBudget;
    private String tourColor;
}
