package com.green.firstproject.tourschedule;

import com.green.firstproject.tourschedule.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourScheduleMapper {
    int postSchedule(TourSchedulePostReq p);

    int deleteSchedule(TourScheduleDeleteReq p);

    TourScheduleGetRes getTourSchedule(long tourScheduleId);

    List<TourScheduleGetListRes> getTourScheduleList(TourScheduleGetReq p);

    int updateScheduleDay(TourSchedulePatchReq p);
}
