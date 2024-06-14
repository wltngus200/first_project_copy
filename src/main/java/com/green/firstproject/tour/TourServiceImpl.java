package com.green.firstproject.tour;

import com.green.firstproject.tour.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TourServiceImpl implements TourService{
    private final TourMapper mapper;

    @Override
    public long postTour(TourPostReq p) {
        if(p.getTitle() == null || p.getTitle().isBlank()) {
            throw new RuntimeException("제목이 비어있거나 입력되지 않음");
        }
        if(p.getTourLocation() == null || p.getTourLocation().isBlank()) {
            throw new RuntimeException("목적지가 비어있거나 입력되지 않음");
        }
        if(p.getTourStartDay() == null || p.getTourStartDay().isBlank()) {
            throw new RuntimeException("시작일이 비어있거나 입력되지 않음");
        }
        if(p.getTourFinishDay() == null || p.getTourFinishDay().isBlank()) {
            throw new RuntimeException("종료일이 비어있거나 입력되지 않음");
        }
        if(p.getTourBudget() < 0) {
            throw new RuntimeException("예산에 음수 값을 입력할 수 없음");
        }
        if(p.getTourColor() == null || p.getTourColor().isBlank()) {
            throw new RuntimeException("색상 코드가 비어있거나 입력되지 않음");
        }
        mapper.postTour(p);
        return p.getTourId();
    }

    @Override
    public List<TourGetRes> getTour(long signedUserId) {
        return mapper.getTour(signedUserId);
    }

    @Override
    public TourGetDetailRes getTourDetail(long tourId) {
        return mapper.getTourDetail(tourId);
    }

    @Override
    public int putTour(long tourId, TourPutReq p) {
        if(p.getTitle() == null || p.getTitle().isBlank()) {
            throw new RuntimeException("제목이 비어있거나 입력되지 않음");
        }
        if(p.getTourLocation() == null || p.getTourLocation().isBlank()) {
            throw new RuntimeException("목적지가 비어있거나 입력되지 않음");
        }
        if(p.getTourStartDay() == null || p.getTourStartDay().isBlank()) {
            throw new RuntimeException("시작일이 비어있거나 입력되지 않음");
        }
        if(p.getTourFinishDay() == null || p.getTourFinishDay().isBlank()) {
            throw new RuntimeException("종료일이 비어있거나 입력되지 않음");
        }
        if(p.getTourBudget() < 0) {
            throw new RuntimeException("예산에 음수 값을 입력할 수 없음");
        }
        if(p.getTourColor() == null || p.getTourColor().isBlank()) {
            p.setTourColor("#000000");
        }
        p.setTourId(tourId);
        return mapper.putTour(p);
    }

    @Override
    public int deleteTour(TourDelReq p) {
        return mapper.deleteTour(p);
    }

}
