package com.green.firstproject.tourchecklist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetCheckListReq {
    @JsonIgnore
    private long checklistId;
    @Schema(name = "tour_id", description = "여행정보")
    private long tourId;


}
