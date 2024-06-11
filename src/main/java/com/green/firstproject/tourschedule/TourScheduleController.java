package com.green.firstproject.tourschedule;

import com.green.firstproject.common.model.ResultDto;
import com.green.firstproject.tourschedule.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/tour/schedule")
public class TourScheduleController {
    private final TourScheduleService service;

    @PostMapping
    @Operation(summary = "일정 스케줄 등록", description =
            "<strong > 일정 스케줄 등록 </strong> <p></p>" +
                    "<p> tourId : 여행 PK (long) </p>" +
                    "<p> tourScheduleDay : 여행 일자 (String) </p>" +
                    "<p> tourScheduleStart : 시작 시간(String) </p>" +
                    "<p> tourScheduleEnd : 끝나는 시간(String) </p>" +
                    "<p> title : 제목(String) </p>" +
                    "<p> contents : 내용(String) </p>" +
                    "<p> cost : 예산(long) </p>")
    public ResultDto<Long> postSchedule(@RequestBody TourSchedulePostReq p) {
        long result = service.postSchedule(p);

        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }

    @DeleteMapping
    @Operation(summary = "일정 스케줄 삭제", description =
            "<strong > 일정 스케줄 삭제 </strong> <p></p>" +
                    "<p> tourId : 여행 PK (long) </p>" +
                    "<p> tourScheduleId : 여행 스케줄 PK (long) </p>")
    public ResultDto<Integer> deleteSchedule(@ParameterObject @ModelAttribute TourScheduleDeleteReq p) {
        int result = service.deleteSchedule(p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }

    @GetMapping("{tourScheduleId}")
    @Operation(summary = "일정 스케줄 상세페이지", description =
            "<strong > 일정 스케줄 등록 </strong> <p></p>" +
                    "<p> tourScheduleId : 여행 스케줄 PK (long) </p>")
    public ResultDto<TourScheduleGetRes> getTourSchedule(@PathVariable long tourScheduleId) {
        TourScheduleGetRes result = service.getTourSchedule(tourScheduleId);


        return ResultDto.<TourScheduleGetRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }

    @GetMapping("tourScheduleList")
    @Operation(summary = "일정 스케줄 리스트", description =
            "<strong > 일정 스케줄 등록 </strong> <p></p>" +
                    "<p> tourId : 여행 PK (long) </p>" +
                    "<p> tourScheduleDay : 여행 일자 (String) </p>")
    public ResultDto<List<TourScheduleGetListRes>> getTourScheduleList(@ParameterObject @ModelAttribute TourScheduleGetReq p) {
        List<TourScheduleGetListRes> result = service.getTourScheduleList(p);

        return ResultDto.<List<TourScheduleGetListRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }

    @PutMapping
    @Operation(summary = "일정 스케줄 수정", description =
            "<strong > 일정 스케줄 수정 </strong> <p></p>" +
                    "<p> tourScheduleDay : 여행 일자 (String) </p>" +
                    "<p> tourScheduleStart : 시작 시간(String) </p>" +
                    "<p> tourScheduleEnd : 끝나는 시간(String) </p>" +
                    "<p> title : 제목(String) </p>" +
                    "<p> contents : 내용(String) </p>" +
                    "<p> cost : 예산(long) </p>" +
                    "<p> tourScheduleId : 여행 스케줄 PK </p>")
    public ResultDto<Integer> updateScheduleDay(@RequestBody TourSchedulePutReq p) {
        int result = service.updateScheduleDay(p);
        log.info("result : {}", result);
        log.info("p : {}", p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result)
                .build();
    }
}
