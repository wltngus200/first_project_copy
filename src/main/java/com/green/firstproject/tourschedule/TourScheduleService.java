package com.green.firstproject.tourschedule;


import com.green.firstproject.tourschedule.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TourScheduleService {
    private final TourScheduleMapper mapper;

    public long postSchedule(TourSchedulePostReq p) {

        if(p.getCost() < 0) {
            throw new RuntimeException("음수를 입력 할 수 없음");
        }
        if(p.getTitle() == null || p.getTitle().isBlank()) {
            throw new RuntimeException("제목은 필수값");
        }
        if(p.getTourScheduleStart() == null || p.getTourScheduleStart().isBlank()) {
            throw new RuntimeException("시작 시간은 필수값");
        }
        if(p.getTourScheduleDay() == null || p.getTourScheduleDay().isBlank()) {
            throw new RuntimeException("날짜 다시 선택");
        }
        //중복 체크
        int check = mapper.getTourScheduleCheck(p.getTourScheduleDay(), p.getTourScheduleStart(), p.getTitle());

        log.info("check : {}", check);

        if(check > 0) {
            throw new RuntimeException("중복된 일정");
        }
        //  insert 스케줄
        int result = mapper.postSchedule(p);

        if(result == 0L) {
            throw new RuntimeException("등록에 실패 했습니다");
        }
        return p.getTourScheduleId();


    }

    public int deleteSchedule(TourScheduleDeleteReq p) {
        int result = mapper.deleteSchedule(p);

        if(result == 0) {
            throw new RuntimeException("삭제 실패");
        }
        return result;
    }

    public TourScheduleGetRes getTourSchedule(long tourScheduleId) {
        TourScheduleGetRes result = mapper.getTourSchedule(tourScheduleId);
        log.info("result : {}", result);
        if(result == null) {
            throw new RuntimeException("조회 실패");
        }
        return result;
    }

    public List<TourScheduleGetListRes> getTourScheduleList(TourScheduleGetReq p) {
        List<TourScheduleGetListRes> result = mapper.getTourScheduleList(p);
        if(result == null) {
            throw new RuntimeException("리스트 조회 실패");
        }
        return result;
    }

    public int updateScheduleDay(TourSchedulePutReq p) {
        if(p.getCost() < 0) {
            throw new RuntimeException("음수를 입력 할 수 없음");
        }
        if(p.getTourScheduleDay() == null || p.getTourScheduleDay().isBlank()) {
            throw new RuntimeException("날짜 다시 선택");
        }
        if(p.getTitle() == null || p.getTitle().isBlank()) {
            throw new RuntimeException("제목은 필수값");
        }
        if(p.getTourScheduleStart() == null || p.getTourScheduleStart().isBlank()) {
            throw new RuntimeException("시작 시간은 필수값");
        }

        int result = mapper.updateScheduleDay(p);
        if(result == 0) {
            throw new RuntimeException("수정 실패");
        }

        return result;
    }

}
