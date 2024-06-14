package com.green.firstproject.tour;

import com.green.firstproject.tour.model.*;

import java.util.List;

public interface TourService {
    long postTour(TourPostReq p);
    List<TourGetRes> getTour(long signedUserId);
    TourGetDetailRes getTourDetail(long tourId);
    int putTour(long tourId, TourPutReq p);
    int deleteTour(TourDelReq p);
}
