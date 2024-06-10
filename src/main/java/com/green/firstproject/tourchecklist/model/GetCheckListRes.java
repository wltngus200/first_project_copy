package com.green.firstproject.tourchecklist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetCheckListRes {
    @Schema(name = "checklist_id")
    private long checklistId;
    @Schema(name = "tour_id",description = "여행정보")
    private long tourId;
    @Schema(description = "준비물품")
    private String title;
}
