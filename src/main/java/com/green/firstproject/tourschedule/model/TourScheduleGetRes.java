package com.green.firstproject.tourschedule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourScheduleGetRes {
    private long tourScheduleId;
    private String tourScheduleDate;
    private String tourScheduleStart;
    private String tourScheduleEnd;
    private String title;
}
