package com.green.firstproject.tour.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TourGetDetailRes {
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
    @Schema(defaultValue = "100000")
    private long tourBudget;
    @Schema(defaultValue = "2024-06-05 14:26:30")
    private String createdAt;
    @Schema(defaultValue = "2024-06-05 14:27:30")
    private String updatedAt;
}
