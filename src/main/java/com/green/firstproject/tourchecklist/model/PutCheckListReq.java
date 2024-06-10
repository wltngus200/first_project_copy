package com.green.firstproject.tourchecklist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PutCheckListReq {
    @Schema(name = "checklist_id")
    private long checklistId;
    @Schema(description = "여행물품")
    private String title;
}
