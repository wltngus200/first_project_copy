package com.green.firstproject.tourschedule.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class TourScheduleGetListRes {
    @Schema(name = "tour_schedule_id")
    private long tourScheduleId;

    @Schema(name = "tour_schedule_day")
    private String tourScheduleDay;

    @Schema(name = "tour_schedule_start")
    private String tourScheduleStart;

    @Schema(name = "tour_schedule_end")
    private String tourScheduleEnd;

    private String title;


}
