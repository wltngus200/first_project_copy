package com.green.firstproject.tour;

import com.green.firstproject.tour.model.*;

import java.util.List;

public interface TourService {
    long postTour(TourPostReq p);
    List<TourGetRes> getTour(TourGetReq p);
    TourGetOneRes getTourOne(long tourId);
    int putTour(TourPutReq p);
    int deleteTour(TourDelReq p);
}
