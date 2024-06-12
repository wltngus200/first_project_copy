package com.green.firstproject.user;

import com.green.firstproject.common.model.Result;
import com.green.firstproject.common.model.ResultDto;
import com.green.firstproject.common.model.ResultError;
import com.green.firstproject.common.model.ResultSuccess;
import com.green.firstproject.user.model.*;
import com.green.firstproject.user.userexception.UserEmailException;
import com.green.firstproject.user.userexception.UserIdNotFoundException;
import com.green.firstproject.user.userexception.UserPasswordException;
import com.green.firstproject.user.userexception.UserValidNotSuccessException;
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
                    "<p> -2 :  아이디 유효성 검사 통과 실패</p> " +
                    "<p> -3 :  설정한 비밀번호 재확인 필요</p> " +
                    "<p> -4 :  비밀번호 유효성 검사 통과 실패</p> " +
                    "<p> -5 :  이메일 유효성 검사 통과 실패 </p> " +
                    "<p> -6 : 이메일 중복 검사 통과 실패 </p>"
    )

    public Result signUpUser(@RequestBody SignUpReq p){
        log.info("p : {}", p);
        //유효성 검사
        try {
            service.validateUser(p);
        } catch (UserValidNotSuccessException e) {
            return ResultError.builder().resultMsg(e.getMessage()).statusCode(-2).build();
        } catch (UserPasswordException e) {
            return ResultError.builder().resultMsg(e.getMessage()).statusCode(-4).build();
        } catch (UserEmailException e) {
            return ResultError.builder().resultMsg(e.getMessage()).statusCode(-5).build();
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
            description = "<strong> 변수명 : uid </strong> <p> 회원 아이디 ex)abc1231 </p>"+"\n"+
                          "<strong> 변수명 : upw </strong> <p> 회원 비밀번호 ex)aa123 </p>" +"\n")
    public ResultDto<SignInRes> signInUser(@RequestBody SignInReq p){
        SignInRes result=service.signInUser(p);
        log.info("{},{}",p,result);
        return ResultDto.<SignInRes>builder()
                .statusCode(HttpStatus.OK)
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
            description = "<strong> 변수명 : user_id </strong> <p> 회원 PK ex)17 </p>")
    public ResultDto<UserEntity> getUserInfo(@RequestParam(name="user_id") long userId){
        UserEntity user=service.getUserInfo(userId);
        return ResultDto.<UserEntity>builder()
                .statusCode(HttpStatus.OK)
                .resultData(user)
                .resultMsg("회원정보 열람")
                .build();
    }
}
