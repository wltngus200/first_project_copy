package com.green.firstproject.tour;


import com.green.firstproject.common.model.ResultDto;
import com.green.firstproject.tour.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/tour")
public class TourControllerImpl {
    private final TourService service;
    @GetMapping
    @Operation(summary = "여행계획 리스트",
            description = "<strong >로그인한 유저의 pk를 받아 해당 유저의 여행계획 출력</strong> <p></p>" +
            "<p>tourId : 여행 PK(long)</p>" +
            "<p>title : 여행 제목(String)</p>" +
            "<p>tourLocation : 여행 위치(String)</p>" +
            "<p>tourStartDay : 여행 시작일(String)</p>" +
            "<p>tourFinishDay : 여행 종료일(String)</p>" +

            "<p>tourColor : 일정표에 표시될 색상(String)</p>")
    public ResultDto<List<TourGetRes>> getTour(@RequestParam("signed_user_id") long signedUserId) {
        List<TourGetRes> result = service.getTour(signedUserId);

        return ResultDto.<List<TourGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result).build();
    }

    @GetMapping("detail")
    @Operation(summary = "여행 계획 상세정보",
            description = "<strong >여행계획의 PK를 입력받아 여행계획의 상세정보 확인 가능</strong> <p></p>" +
            "<p>tourId : 여행 PK(long)</p>" +
            "<p>title : 여행 제목(String)</p>" +
            "<p>tourLocation : 여행 위치(String)</p>" +
            "<p>tourStartDay : 여행 시작일(String)</p>" +
            "<p>tourFinishDay : 여행 종료일(String)</p>" +
            "<p>tourBudget : 여행 예산(long)</p>" +
            "<p>createdAt : 생성 시각(String)</p>" +
            "<p>updatedAt : 수정 시각(String)</p>")
    public ResultDto<TourGetDetailRes> getTourDetail(@RequestParam("tour_id") long tourId) {
        TourGetDetailRes result = service.getTourDetail(tourId);
        return ResultDto.<TourGetDetailRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result).build();
    }
    @PostMapping
    @Operation(summary = "여행 계획 작성",
            description = "<strong >여행 계획 작성, 여행 계획의 PK 리턴</strong> <p></p>" +
                            "<p>userId : 유저 PK(long)</p>" +
                            "<p>title : 여행 제목(String)</p>" +
                            "<p>tourLocation : 여행 위치(String)</p>" +
                            "<p>tourStartDay : 여행 시작일(String)</p>" +
                            "<p>tourFinishDay : 여행 종료일(String)</p>" +
                            "<p>tourBudget : 여행 예산(long)</p>" +
                            "<p>tourColor : 일정표에 표시될 색상(String)</p>")
    public ResultDto<Long> postTour(@RequestBody TourPostReq p) {
        long result = service.postTour(p);
        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result).build();
    }
    @DeleteMapping
    @Operation(summary = "여행 계획 삭제", description = "로그인한 유저 pk와 여행계획 pk를 입력받아 삭제")
    public ResultDto<Integer> deleteTour(@ParameterObject @ModelAttribute TourDelReq p) {
        int result = service.deleteTour(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result).build();
    }
    @PutMapping
    @Operation(summary = "여행 계획 수정", description = "<strong >정보를 입력받아 여행 계획 수정</strong> <p></p>" +
            "<p>tourId : 여행 PK(long)</p>" +
            "<p>title : 여행 제목(String)</p>" +
            "<p>tourLocation : 여행 위치(String)</p>" +
            "<p>tourStartDay : 여행 시작일(String)</p>" +
            "<p>tourFinishDay : 여행 종료일(String)</p>" +
            "<p>tourColor : 일정표에 표시될 색상(String)</p>")
    public ResultDto<Integer> putTour(@RequestBody TourPutReq p) {
        int result = service.putTour(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result).build();
    }
}
