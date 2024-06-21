package com.green.firstproject.main;

import com.green.firstproject.main.model.MainGetRes;
import com.green.firstproject.tourchecklist.model.GetCheckListRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final MainMapper mapper;
    public MainGetRes getMain(long signedUserId) {
        MainGetRes mainRes = mapper.getMainTour(signedUserId);
        if(mainRes != null) {
            String name = mapper.getUserName(signedUserId);
            mainRes.setName(name);
            List<GetCheckListRes> mainChecklist = mapper.getMainChecklist(mainRes.getTourId());
            mainRes.setCheckList(mainChecklist);
        }
        else {
            String name = mapper.getUserName(signedUserId);
            mainRes = MainGetRes.builder().name(name).build();
        }
        return mainRes;
    }
}
