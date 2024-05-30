package com.green.firstproject.tour;

import com.green.firstproject.tour.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourServiceImpl implements TourService{
    private final TourMapper mapper;

    @Override
    public long postTour(TourPostReq p) {
        mapper.postTour(p);
        return p.getTourId();
    }

    @Override
    public List<TourGetRes> getTour(TourGetReq p) {
        return mapper.getTour(p);
    }

    @Override
    public TourGetOneRes getTourOne(long tourId) {
        return mapper.getTourOne(tourId);
    }

    @Override
    public int putTour(TourPutReq p) {
        return mapper.putTour(p);
    }

    @Override
    public int deleteTour(TourDelReq p) {
        return mapper.deleteTour(p);
    }

}
