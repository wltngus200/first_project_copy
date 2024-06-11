package com.green.firstproject.tourchecklist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Setter
@Getter
public class GetCheckListReq {
    @Schema(name = "tour_id", description = "여행정보")
    private long tourId;
    @ConstructorProperties({"tour_id"})
    public GetCheckListReq(long tourId) {
        this.tourId = tourId;
    }
}
