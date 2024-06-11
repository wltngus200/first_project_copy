package com.green.firstproject.tourchecklist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PutCheckListRes {
    private long checklistId;
    private long tourId;
    private String title;
}
