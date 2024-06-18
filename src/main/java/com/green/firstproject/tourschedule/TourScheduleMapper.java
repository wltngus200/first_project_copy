package com.green.firstproject.tourschedule;

import com.green.firstproject.tourschedule.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TourScheduleMapper {
    int postSchedule(TourSchedulePostReq p);

    int deleteSchedule(TourScheduleDeleteReq p);

    TourScheduleGetRes getTourSchedule(long tourScheduleId);

    List<TourScheduleGetListRes> getTourScheduleList(TourScheduleGetReq p);

    int updateScheduleDay(TourSchedulePutReq p);

    int getTourScheduleCheck(@Param("tourScheduleDay") String tourScheduleDay,
                             @Param("tourScheduleStart") String tourScheduleStart,
                             @Param("tourScheduleTitle") String title);

}
