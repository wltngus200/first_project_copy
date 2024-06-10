package com.green.firstproject.tourschedule.model;

import lombok.Data;

@Data
public class TourScheduleGetRes {
    private long tourScheduleId;
    private long tourScheduleDay;
    private String tourScheduleStart;
    private String tourScheduleEnd;
    private String title;
    private String contents;
    private String cost;
}
