package com.green.firstproject.tourchecklist;

import com.green.firstproject.tourchecklist.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CheckListService {
    private final CheckListMapper mapper;

    public int postCheckList(PostCheckListReq p) {
        log.info("{}", p.toString());
        return mapper.postCheckList(p);
    }

    public int putCheckList(PutCheckListReq p) {

        return mapper.putCheckList(p);
    }

    public int deleteCheckList(int checklistId){
        return mapper.deleteCheckList(checklistId);
    }

    public List<GetCheckListRes> getCheckList(GetCheckListReq p){
        List<GetCheckListRes> list = mapper.getCheckList(p);

        return list;
    }

    public int toggleCheckList(ToggleCheckList p){
        return mapper.toggleCheckList(p);

    }
}
