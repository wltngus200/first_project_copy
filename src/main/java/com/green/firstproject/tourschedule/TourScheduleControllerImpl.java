package com.green.firstproject.tourschedule;

import com.green.firstproject.common.model.ResultDto;
import com.green.firstproject.tourschedule.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tour/schedule")
@Slf4j
public class TourScheduleControllerImpl {
    @PostMapping
    public ResultDto<Integer> postSchedule(@RequestBody TourSchedulePostReq p) {
        return null;
    }
    @GetMapping
    public ResultDto<List<TourScheduleGetRes>> getSchedule(@RequestParam long tourId) {
        return null;
    }
    @GetMapping("{tourScheduleId}")
    public ResultDto<TourScheduleGetDetailRes> getScheduleDetail(@RequestParam long tourScheduleId) {
        return null;
    }
    @PutMapping
    public ResultDto<Integer> putSchedule(TourSchedulePutReq p) {
        return null;
    }
    @DeleteMapping
    public ResultDto<Integer> deleteSchedule(TourScheduleDelReq p) {
        return null;
    }
}
