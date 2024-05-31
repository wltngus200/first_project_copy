package com.green.firstproject.tourschedule;


import com.green.firstproject.tourschedule.model.*;

import java.util.List;

public interface TourScheduleService {
    int postSchedule(TourSchedulePostReq p);
    List<TourScheduleGetRes> getSchedule(long tourId);
    TourScheduleGetDetailRes getScheduleDetail(long tourScheduleId);
    int putSchedule(TourSchedulePutReq p);
    int deleteSchedule(TourScheduleDelReq p);
}
