package com.green.firstproject.tour;

import com.green.firstproject.tour.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourMapper {
    int postTour(TourPostReq p);
    int putTour(TourPutReq p);
    List<TourGetRes> getTour(long signedUserId);
    TourGetDetailRes getTourDetail(long tourId);
    int deleteTour(TourDelReq p);
}
