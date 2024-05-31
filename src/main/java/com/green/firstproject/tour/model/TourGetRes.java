package com.green.firstproject.tour.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourGetRes {
    private long tourId;
    private String title;
    private String tourLocation;
    private String tourStartDay;
    private String tourFinishDay;
    private String tourColor;
}
