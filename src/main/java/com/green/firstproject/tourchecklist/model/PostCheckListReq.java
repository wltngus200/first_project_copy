package com.green.firstproject.tourchecklist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostCheckListReq {
    @JsonIgnore
    private long checklistId;
    @Schema(name = "tour_id")
    private long tourId;
    @Schema(description = "여행물품")
    private String title;
}
