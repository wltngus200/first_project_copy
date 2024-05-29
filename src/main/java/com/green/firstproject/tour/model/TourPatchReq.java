package com.green.firstproject.tour.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourPatchReq {
    private long tourId;
    private String tourLocation;
    private String tourStartDay;
    private String tourFinishDay;
    private long tourBudget;
    private String tourColor;
}
