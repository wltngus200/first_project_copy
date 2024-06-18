package com.green.firstproject.tourschedule;

import com.green.firstproject.common.model.ResultDto;
import com.green.firstproject.tourschedule.model.*;
import com.green.firstproject.tourschedule.scheduleexception.DuplicateScheduleException;
import com.green.firstproject.tourschedule.scheduleexception.ScheduleRequiredException;
import com.green.firstproject.tourschedule.scheduleexception.ScheduleSaveFailedException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
                    "<p><strong> tourId</strong> : 여행 PK (long) </p>" +
                    "<p><strong> tourScheduleDay</strong> : 여행 일자 (String) </p>" +
                    "<p><strong> tourScheduleStart</strong> : 시작 시간(String) </p>" +
                    "<p><strong> tourScheduleEnd</strong> : 끝나는 시간(String) </p>" +
                    "<p><strong> title</strong> : 제목(String) </p>" +
                    "<p><strong> contents</strong> : 내용(String) </p>" +
                    "<p><strong> cost</strong> : 예산(long) </p>")
    @ApiResponse(
            description =
                    "<p> ResponseCode 응답 코드 </p> " +
                            "<p>  0 : 등록 실패</p> " +
                            "<p>  1 : 정상 </p> " +
                            "<p> -1 : 예산에 음수를 입력하셨거나 필수값(제목, 날짜, 시각)을 입력하지 않으셨습니다 </p> " +
                            "<p> -2 : 중복된 일정입니다</p> " +
                            "<p> -3 : 에러 발생</p> "
    )
    public ResultDto<Long> postSchedule(@RequestBody TourSchedulePostReq p) {
        try {
            long result = service.postSchedule(p);


        return ResultDto.<Long>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("스케줄 등록 성공")
                .resultData(result)
                .build();
        } catch (ScheduleRequiredException e) {
            return ResultDto.<Long>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("예산에 음수를 입력하셨거나 필수값(제목, 날짜, 시각)을 입력하지 않으셨습니다")
                    .resultData(-1L)
                    .build();
        } catch (DuplicateScheduleException e) {
            return ResultDto.<Long>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("중복된 일정입니다")
                    .resultData(-2L)
                    .build();
        } catch (ScheduleSaveFailedException e) {
            return ResultDto.<Long>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("등록 실패")
                    .resultData(0L)
                    .build();
        } catch (Exception e) {
            return ResultDto.<Long>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("에러 발생")
                    .resultData(-3L)
                    .build();
        }
    }

    @DeleteMapping
    @Operation(summary = "일정 스케줄 삭제", description =
            "<strong > 일정 스케줄 삭제 </strong> <p></p>" +
            "<p><strong> tourId</strong> : 여행 PK (long) </p>" +
            "<p><strong> tourScheduleId</strong> : 여행 스케줄 PK (long) </p>")
    @ApiResponse(
            description =
                    "<p> ResponseCode 응답 코드 </p> " +
                            "<p>  0 : 스케줄 삭제 실패</p> " +
                            "<p>  1 : 스케줄 삭제 성공 </p> "
    )
    public ResultDto<Integer> deleteSchedule(@ParameterObject @ModelAttribute TourScheduleDeleteReq p) {
        try {
            int result = service.deleteSchedule(p);


        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("스케줄 삭제 성공")
                .resultData(result)
                .build();
        } catch (RuntimeException e) {
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("스케줄 삭제 실패")
                    .resultData(0)
                    .build();
        }
    }

    @GetMapping("{tourScheduleId}")
    @Operation(summary = "일정 스케줄 상세페이지", description =
            "<strong > 일정 스케줄 등록 </strong> <p></p>" +
            "<p><strong> tourScheduleId</strong> : 여행 스케줄 PK (long) </p>")
    public ResultDto<TourScheduleGetRes> getTourSchedule(@PathVariable("tourScheduleId") long tourScheduleId) {
        try {
            TourScheduleGetRes result = service.getTourSchedule(tourScheduleId);



        return ResultDto.<TourScheduleGetRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("상세 조회 성공")
                .resultData(result)
                .build();
        } catch (RuntimeException e) {
            return ResultDto.<TourScheduleGetRes>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("상세 조회 실패")
                    .resultData(null)
                    .build();
        }
    }

    @GetMapping("tourScheduleList")
    @Operation(summary = "일정 스케줄 리스트", description =
            "<strong > 일정 스케줄 등록 </strong> <p></p>" +
            "<p><strong> tourId</strong> : 여행 PK (long) </p>" +
            "<p><strong> tourScheduleDay</strong> : 여행 일자 (String) </p>")
    public ResultDto<List<TourScheduleGetListRes>> getTourScheduleList(@ParameterObject @ModelAttribute TourScheduleGetReq p) {

        try {

            List<TourScheduleGetListRes> result = service.getTourScheduleList(p);
            if(!(result.isEmpty())) {
                return ResultDto.<List<TourScheduleGetListRes>>builder()
                        .statusCode(HttpStatus.OK)
                        .resultMsg("리스트형태로 조회 성공")
                        .resultData(result)
                        .build();
            } else {
                return ResultDto.<List<TourScheduleGetListRes>>builder()
                        .statusCode(HttpStatus.OK)
                        .resultMsg("등록된 스케줄이 없습니다")
                        .resultData(result)
                        .build();
            }
        } catch (RuntimeException e) {
            return ResultDto.<List<TourScheduleGetListRes>>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("리스트형태로 조회 실패")
                    .resultData(null)
                    .build();
        }
    }

    @PutMapping
    @Operation(summary = "일정 스케줄 수정", description =
            "<strong > 일정 스케줄 수정 </strong> <p></p>" +
                    "<p><strong> tourScheduleDay</strong> : 여행 일자 (String) </p>" +
                    "<p><strong> tourScheduleStart</strong> : 시작 시간(String) </p>" +
                    "<p><strong> tourScheduleEnd</strong> : 끝나는 시간(String) </p>" +
                    "<p><strong> title</strong> : 제목(String) </p>" +
                    "<p><strong> contents</strong> : 내용(String) </p>" +
                    "<p><strong> cost</strong> : 예산(long) </p>" +
                    "<p><strong> tour_schedul_id</strong> : 여행 스케줄 PK </p>")
    @ApiResponse(
            description =
                    "<p> ResponseCode 응답 코드 </p> " +
                            "<p>  0 : 수정 실패</p> " +
                            "<p>  1 : 수정 성공 </p> " +
                            "<p> -1 : 예산에 음수를 입력하셨거나 필수값(제목, 날짜, 시각)을 입력하지 않으셨습니다 </p> " +
                            "<p> -2 : 에러 발생</p> "
    )
    public ResultDto<Integer> updateScheduleDay(@RequestParam(name = "tour_schedule_id") long tourScheduleId, @RequestBody TourSchedulePutReq p) {
        try {
            int result = service.updateScheduleDay(tourScheduleId, p);

        log.info("result : {}", result);
        log.info("p : {}", p);

        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("수정 성공")
                .resultData(result)
                .build();
        } catch (ScheduleRequiredException e) {
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("예산에 음수를 입력하셨거나 필수값(제목, 날짜, 시각)을 입력하지 않으셨습니다")
                    .resultData(-1)
                    .build();
        } catch (ScheduleSaveFailedException e) {
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("수정 실패")
                    .resultData(0)
                    .build();
        } catch (Exception e) {
            return ResultDto.<Integer>builder()
                    .statusCode(HttpStatus.BAD_REQUEST)
                    .resultMsg("에러 발생")
                    .resultData(-2)
                    .build();
        }
    }
}
