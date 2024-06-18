package com.green.firstproject.tourschedule.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TourScheduleGetRes {

    private long tourScheduleId;

    private String tourScheduleDay;
    private String tourScheduleStart;
    private String tourScheduleEnd;
    private String tourScheduleTitle;
    private String contents;
    private String cost;
}
