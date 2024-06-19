package com.green.firstproject.main.model;

import com.green.firstproject.tourchecklist.model.GetCheckListRes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainGetRes {
    @Schema(defaultValue = "1")
    private long tourId;
    @Schema(defaultValue = "제목")
    private String title;
    @Schema(defaultValue = "목적지")
    private String tourLocation;
    @Schema(defaultValue = "2000-01-01")
    private String tourStartDay;
    @Schema(defaultValue = "2000-01-01")
    private String tourFinishDay;
    @Schema(defaultValue = "100000")
    private long tourBudget;
    @Schema(defaultValue = "2024-06-05 14:26:30")
    private String createdAt;
    @Schema(defaultValue = "2024-06-05 14:27:30")
    private String updatedAt;
    @Schema(defaultValue = "이름")
    private String name;
    private List<GetCheckListRes> checkList = new ArrayList<>();
}
