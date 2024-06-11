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
    private String title;
    private long tourId;
}
