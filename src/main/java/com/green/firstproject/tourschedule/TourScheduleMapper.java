package com.green.firstproject.tourschedule;

import com.green.firstproject.tourschedule.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourScheduleMapper {
    int postSchedule(TourSchedulePostReq p);
    List<TourScheduleGetRes> getSchedule(long tourId);
    TourScheduleGetDetailRes getScheduleDetail(long tourScheduleId);
    int putSchedule(TourSchedulePutReq p);
    int deleteSchedule(TourScheduleDelReq p);
}
