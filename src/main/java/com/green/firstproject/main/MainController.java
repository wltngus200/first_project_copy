package com.green.firstproject.main;

import com.green.firstproject.common.model.ResultDto;
import com.green.firstproject.main.model.MainGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/main")
public class MainController {
    private final MainService service;
    @GetMapping
    public ResultDto<MainGetRes> getMain(@RequestParam(name = "signed_user_id")long signedUserId) {
        MainGetRes result = service.getMain(signedUserId);
        return ResultDto.<MainGetRes>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .resultData(result).build();

    }
}
