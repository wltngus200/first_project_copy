package com.green.firstproject.tourschedule.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class TourSchedulePutReq {
    @JsonIgnore
    private long tourScheduleId;
    private String tourScheduleDay;
    private String tourScheduleStart;
    private String tourScheduleEnd;
    private String title;
    private String contents;


    private long cost;
}
