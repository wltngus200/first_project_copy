package com.green.firstproject.tourchecklist;

import com.green.firstproject.tourchecklist.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckListMapper {
    long postCheckList(PostCheckListReq p);
    int putCheckList(PutCheckListReq p);
    int deleteCheckList(int p);
    List<GetCheckListRes> getCheckList(GetCheckListReq p);
    int toggleCheckList(ToggleCheckListReq p);
    int deleteDayCheckList(int p);


}
