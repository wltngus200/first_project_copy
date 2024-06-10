package com.green.firstproject.tourschedule.model;


import lombok.Data;

@Data
public class TourSchedulePatchReq {
    private long tourScheduleId;
    private long tourScheduleDay;
    private String tourScheduleStart;
    private String tourScheduleEnd;
    private String title;
    private String contents;


    private long cost;
}
