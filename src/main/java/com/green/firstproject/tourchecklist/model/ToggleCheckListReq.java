package com.green.firstproject.tourchecklist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Setter
@Getter
public class ToggleCheckListReq {
    @Schema(name = "checklist_id")
    private long checklistId;
    @ConstructorProperties({"checklist_id"})
    public ToggleCheckListReq(long checklistId) {
        this.checklistId = checklistId;
    }

}
