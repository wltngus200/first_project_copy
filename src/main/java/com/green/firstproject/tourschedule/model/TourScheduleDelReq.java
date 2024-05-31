package com.green.firstproject.tourschedule.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourScheduleDelReq {
    private long tourScheduleId;
    private long tourId;
}
