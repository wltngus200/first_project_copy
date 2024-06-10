package com.green.firstproject.tour.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourGetRes {
    @Schema(defaultValue = "1")
    private long tourId;
    @Schema(defaultValue = "제목")
    private String title;
    @Schema(defaultValue = "목적지")
    private String tourLocation;
    @Schema(defaultValue = "2000-01-01")
    private String tourStartDay;
    @Schema(defaultValue = "2000-01-01")
    private String tourFinishDay;
    @Schema(defaultValue = "#FF0000")
    private String tourColor;
}
