package com.green.firstproject.tourschedule.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class TourScheduleDeleteReq {

    @Schema(name = "tour_id")
    private long tourId;

    @Schema(name = "tour_schedule_id")
    private long tourScheduleId;

    @ConstructorProperties({"tour_id", "tour_schedule_id"})
    public TourScheduleDeleteReq(long tourId, long tourScheduleId) {
        this.tourId = tourId;
        this.tourScheduleId = tourScheduleId;
    }
}
