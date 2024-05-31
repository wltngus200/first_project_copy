package com.green.firstproject.tourschedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourSchedulePostReq {
    @JsonIgnore
    private long tourScheduleId;
    private long tourId;
    private String tourScheduleDate;
    private String tourScheduleStart;
    private String tourScheduleEnd;
    private String title;
    private String tag;
    private String contents;
    private long cost;
}
