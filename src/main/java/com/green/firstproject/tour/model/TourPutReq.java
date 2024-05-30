package com.green.firstproject.tour.model;

import lombok.*;

@Getter
@Setter
public class TourPutReq {
    private long tourId;
    private String tourLocation;
    private String tourStartDay;
    private String tourFinishDay;
    private long tourBudget;
    private String tourColor;
}
