package com.green.firstproject.tourchecklist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PostCheckListReq {
    @JsonIgnore
    private long checklistId;
    @Schema(description = "여행물품")
    private String title;
    @Schema(name = "tour_id")
    private long tourId;
}
