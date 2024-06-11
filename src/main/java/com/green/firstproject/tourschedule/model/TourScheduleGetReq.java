package com.green.firstproject.tourschedule.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class TourScheduleGetReq {
    @Schema(name = "tour_id")
    private long tourId;
    @Schema(name = "tour_schedule_day")
    private String tourScheduleDay;

    @ConstructorProperties({"tour_id", "tour_schedule_day"})
    public TourScheduleGetReq(long tourId, String tourScheduleDay) {
        this.tourId = tourId;
        this.tourScheduleDay = tourScheduleDay;
    }
}
