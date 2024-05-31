package com.green.firstproject.tourschedule;

import com.green.firstproject.tourschedule.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TourScheduleServiceImpl implements TourScheduleService{
    private final TourScheduleMapper mapper;

    @Override
    public int postSchedule(TourSchedulePostReq p) {
        return mapper.postSchedule(p);
    }

    @Override
    public List<TourScheduleGetRes> getSchedule(long tourId) {
        return mapper.getSchedule(tourId);
    }

    @Override
    public TourScheduleGetDetailRes getScheduleDetail(long tourScheduleId) {
        return mapper.getScheduleDetail(tourScheduleId);
    }

    @Override
    public int deleteSchedule(TourScheduleDelReq p) {
        return mapper.deleteSchedule(p);
    }

    @Override
    public int putSchedule(TourSchedulePutReq p) {
        return 0;
    }
}

