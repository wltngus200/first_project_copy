package com.green.firstproject.tour.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourGetDetailRes {
    private long tourId;
    private String title;
    private String tourLocation;
    private String tourStartDay;
    private String tourFinishDay;
    private long tourBudget;
    private String createdAt;
    private String updatedAt;
}
