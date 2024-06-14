package com.green.firstproject.user;

import com.green.firstproject.common.model.Result;
import com.green.firstproject.common.model.ResultDto;
import com.green.firstproject.common.model.ResultError;
import com.green.firstproject.common.model.ResultSuccess;
import com.green.firstproject.user.model.*;
import com.green.firstproject.user.userexception.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    @Operation(summary = "유저 회원가입",
            description = "<strong> 변수명 : uid </strong> <p> 회원 아이디 ex)abc1231 </p>" +
                          "<strong> 변수명 : upw </strong> <p> 회원 비밀번호 ex)aa123 </p>" +
                          "<strong> 변수명 : nm </strong> <p> 회원 이름 ex)홍길동 </p>" +
                          "<strong> 변수명 : email </strong> <p> 회원 이메일 ex)abc1231@naver.com </p>")
    @ApiResponse(
            description =
                    "<p> ResponseCode 응답 코드 </p> " +
                    "<p>  1 : 정상 </p> " +
                    "<p> -1 : 아이디가 중복 됨 </p> " +
                    "<p> -2 : 아이디 유효성 검사 통과 실패</p> " +
                    "<p> -3 : 비밀번호 유효성 검사 통과 실패</p> " +
                    "<p> -4 : 이메일 유효성 검사 통과 실패 </p> " +
                    "<p> -5 : 이메일 조회 SQL 실패 </p>" +
                    "<p> -6 : 이메일 중복 </p>"
    )
    public Result signUpUser(@RequestBody SignUpReq p){
        log.info("p : {}", p);
        //유효성 검사
        try {
            service.validateUser(p);
        } catch (UserValidNotSuccessException e) {
            return ResultError.builder().resultMsg(e.getMessage()).statusCode(-2).build();
        } catch (UserPasswordException e) {
            return ResultError.builder().resultMsg(e.getMessage()).statusCode(-3).build();
        } catch (UserEmailException e) {
            return ResultError.builder().resultMsg(e.getMessage()).statusCode(-4).build();
        }
        int checkDuplicate = 0;
        // email SQL 에러
        try {
            checkDuplicate = service.checkDuplicateEmail(p);
        } catch (Exception e) {
            return ResultError.builder().resultMsg(e.getMessage()).statusCode(-5).build();
        }
        //email 중복검사
        if (checkDuplicate != 1) {
            return ResultError.builder().resultMsg(UserErrorMessage.USER_EMAIL_DUPLICATED_MESSAGE).statusCode(-6).build();
        }

        //검증 통과 DB IN
        int result = service.signUpUser(p);

        log.info("DB IN p2 : {}",  p);

        return ResultSuccess.<Integer>builder()
                .statusCode(1)
                .resultData(result)
                .resultMsg("회원가입에 성공하였습니다.")
                .build();

    }
    @PostMapping("sign-in")
    @Operation(summary="유저 로그인",
            description = "<strong> 변수명 : uid </strong> <p> 회원 아이디 ex)abc1231 </p>"+
                          "<strong> 변수명 : upw </strong> <p> 회원 비밀번호 ex)aa123 </p>")
    @ApiResponse(
            description =
                    "<p> ResponseCode 응답 코드 </p> " +
                    "<p>  1 : 정상 </p> " +
                    "<p> -1 : 아이디가 존재하지않음 </p> " +
                    "<p> -2 : 비밀번호가 틀림</p> "
    )
    public Result signInUser(@RequestBody SignInReq p){
        SignInRes result = null;
        try {
            result = service.signInUser(p);
        } catch (UserNotFoundException e) {
            return ResultError.builder().statusCode(-1).resultMsg(e.getMessage()).build();
        } catch (UserPasswordException e) {
             return ResultError.builder().statusCode(-2).resultMsg(e.getMessage()).build();
        }

        log.info("{},{}",p,result);

        return ResultSuccess.<SignInRes>builder()
                .statusCode(1)
                .resultData(result)
                .resultMsg("로그인에 성공하였습니다.")
                .build();
    }
    @PutMapping("password")
    @Operation(summary="비밀번호 수정",
            description=
                    "<strong> 변수명 : uid </strong> <p> 회원 아이디 ex)abc1231 </p>"+"\n"+
                    "<strong> 변수명 : upw </strong> <p> 회원 비밀번호 ex)aa123 </p>" +"\n"+
                    "<strong> 변수명 : newPw </strong> <p> 새로운 비밀번호 ex)bb123 </p>"+"\n")
    public ResultDto<Integer> updateUpw(@ModelAttribute @ParameterObject ChangeUpwReq p){
        int result=service.updateUpw(p);
        return ResultDto.<Integer>builder()
                .resultMsg("비밀번호를 성공적으로 변경하였습니다.")
                .resultData(result)
                .statusCode(HttpStatus.OK)
                .build();
    }

    @DeleteMapping
    @Operation(summary="회원 탈퇴",
            description="<strong> 변수명 : user_id </strong> <p> 회원 PK ex)17 </p>")
    public ResultDto<Integer> deleteUserInfo(@RequestParam(name="user_id") long userId) {
        int result = service.deleteUserInfo(userId);
        return ResultDto.<Integer>builder()
                .resultMsg("탈퇴처리가 완료되었습니다.")
                .statusCode(HttpStatus.OK)
                .resultData(result)
                .build();
    }

    @GetMapping
    @Operation(summary="마이 페이지",
            description = "<strong> 변수명 : uid </strong> <p> 회원 PK ex)17 </p>")
    public ResultDto<UserEntity> getUserInfo(@RequestParam(name = "uid") String uid){
        UserEntity user=service.getUserInfo(uid);
        return ResultDto.<UserEntity>builder()
                .statusCode(HttpStatus.OK)
                .resultData(user)
                .resultMsg("회원정보 열람")
                .build();
    }
}
