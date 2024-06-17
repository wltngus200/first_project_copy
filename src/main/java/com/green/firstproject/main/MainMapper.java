package com.green.firstproject.main;

import com.green.firstproject.main.model.MainGetRes;
import com.green.firstproject.tourchecklist.model.GetCheckListRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    MainGetRes getMainTour(long signedUserId);
    List<GetCheckListRes> getMainChecklist(long tourId);

}
