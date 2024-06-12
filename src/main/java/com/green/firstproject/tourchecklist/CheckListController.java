package com.green.firstproject.tourchecklist;

import com.green.firstproject.tourchecklist.model.*;
import com.green.firstproject.common.model.ResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tour/checklist")
@RequiredArgsConstructor
@Slf4j
public class CheckListController {
    private final CheckListService service;

    @PostMapping
    @Operation(summary = "여행물품 등록", description =
            "<p><strong>tour_id </strong>: 투어PK(long)" +
            "<p><strong>title</strong> : 투어타이틀(String)"
    )
    public ResultDto<Integer> postCheckList(@RequestBody PostCheckListReq p){
        log.info("p: {}", p);
        int result = service.postCheckList(p);


        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("check list에 등록되었습니다.")
                .build();
    }

    @PutMapping
    @Operation(summary = "여행물품 수정",
            description =
                    "<p> 변수명 : checklist_id(long) </p>" +
                    "<p> 변수명 : title(String) </p>"
    )
    public ResultDto<Integer> putCheckList(@RequestBody PutCheckListReq p){
        int result = service.putCheckList(p);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("check list를 수정하였습니다.")
                .build();
    }

    @DeleteMapping
    @Operation(summary = "여행물품 삭제",
            description =
                    "<p> 변수명 : checklist_id(long) </p>"
    )
    public ResultDto<Integer> deleteCheckList(@RequestParam("checklist_id") int checklistId){
        int result = service.deleteCheckList(checklistId);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("check list를 삭제하였습니다.")
                .build();
    }

    @GetMapping
    @Operation(summary = "여행물품 리스트",
            description =
                    "<p> 변수명 : tour_id </p>"
    )
    public ResultDto<List<GetCheckListRes>> getCheckList(@ParameterObject @ModelAttribute GetCheckListReq p){
        List<GetCheckListRes> result = service.getCheckList(p);

        return ResultDto.<List<GetCheckListRes>>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .build();
    }

    @PatchMapping
    @Operation(summary = "여행물품 체크")
    public ResultDto<Integer> toggleCheckList(@RequestBody ToggleCheckList p){
        int result = service.toggleCheckList(p);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("")
                .build();
    }
    @DeleteMapping("/day")
    @Operation(summary = "전체삭제")
    public ResultDto<Integer> deleteDayCheckList(@RequestParam("tour_id") int tourId){
        int result = service.deleteDayCheckList(tourId);

        return ResultDto.<Integer>builder()
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .resultMsg("물품을 삭제하였습니다.")
                .build();
    }
}
