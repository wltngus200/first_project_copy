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
    private final TourServiceImpl service;
    @GetMapping
    @Operation(summary = "여행계획 리스트", description = "기간과 로그인한 유저의 pk를 받아 일정 출력")
    public ResultDto<List<TourGetRes>> getTour(@ParameterObject @ModelAttribute TourGetReq p) {
        List<TourGetRes> result = service.getTour(p);

        return ResultDto.<List<TourGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .result(result).build();
    }
    @GetMapping("{tourId}")
    @Operation(summary = "여행 계획 상세정보", description = "해당 여행계획의 상세정보 확인 가능")
    public ResultDto<TourGetOneRes> getTourOne(@RequestParam(name = "tour_id") long tourId) {
        TourGetOneRes result = service.getTourOne(tourId);
        return ResultDto.<TourGetOneRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .result(result).build();
    }
    @PostMapping
    @Operation(summary = "여행 계획 작성", description = "여행 계획 정보를 입력받음")
    public ResultDto<Long> postTour(@RequestBody TourPostReq p) {
        long result = service.postTour(p);
        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .result(result).build();
    }
    @DeleteMapping
    @Operation(summary = "여행 계획 삭제", description = "로그인한 유저 pk와 여행계획 pk를 입력받아 삭제")
    public ResultDto<Integer> deleteTour(@ParameterObject @ModelAttribute TourDelReq p) {
        int result = service.deleteTour(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .result(result).build();
    }
    @PutMapping
    @Operation(summary = "여행 계획 수정", description = "여행 계획 수정")
    public ResultDto<Integer> putTour(@RequestBody TourPutReq p) {
        int result = service.putTour(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .result(result).build();
    }
}
