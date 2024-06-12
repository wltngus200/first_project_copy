package com.green.firstproject.user;

import com.green.firstproject.common.CustomFileUtils;
import com.green.firstproject.user.check.Validator;
import com.green.firstproject.user.model.*;
import com.green.firstproject.user.userexception.UserEmailException;
import com.green.firstproject.user.userexception.UserErrorMessage;
import com.green.firstproject.user.userexception.UserPasswordException;
import com.green.firstproject.user.userexception.UserValidNotSuccessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

import static com.green.firstproject.user.model.IDCheck.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils utils;

    @Transactional
    public int signUpUser(SignUpReq p) {
        /*if(!isValidId(p.getUid())) {//정규식에 어긋남
            //if는 괄호 안이 true일 경우 실행
            //정규식에 맞으면 true를 출력
            //(!false)=>TRUE 즉, 정규식이 안 맞으면 실행으로 바뀌는 것
              //(!true)=>FALSE => 실행 X
            throw new RuntimeException("올바르지 않은 아이디입니다.");
        }
        if(mapper.searchUser(p.getUid())!=0){
            throw new RuntimeException("중복된 아이디입니다.");
        }
        if(!isValidPassword(p.getUpw())){ //정규식에 어긋남
            throw new RuntimeException("비밀번호에 허용되지 않은 특수문자가 사용되었습니다.");
        }
        if(!isValidEmail(p.getEmail())){
            throw new RuntimeException("올바르지 않은 이메일입니다.");
        }*/

        String hashPass = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashPass);
        int result=mapper.signUpUser(p);

        return result;
    }

    public SignInRes signInUser(SignInReq p) {
        UserEntity user = mapper.signInUser(p);
        if (user == null) {
            throw new RuntimeException("아이디가 틀렸습니다.");
        } else if (!BCrypt.checkpw(p.getUpw(), user.getUpw())) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }
        SignInRes res = SignInRes.builder()
                .userId(user.getUserId())
                .uid(user.getUid())
                .upw(user.getUpw())
                .build();
        return res;
    }
    //저장된 이메일 통해서 비밀번호 재발급과 비밀번호 바꾸기... 다른 개념?
    public int updateUpw(ChangeUpwReq p) {
        SignInReq req = SignInReq.builder().uid(p.getUid()).upw(p.getUpw()).build();
        signInUser(req);//바꾸기 전, 재 로그인으로 본인 확인
        //리턴 없이
        String newHashPass = BCrypt.hashpw(p.getNewPw(), BCrypt.gensalt());
        p.setNewPw(newHashPass);

        return mapper.updateUpw(p);
    }


    public int deleteUserInfo(long userId) {
        String shortPath = String.format("/user/%d", userId);
        utils.deleteFolder(shortPath);
        return mapper.deleteUserInfo(userId);
        //탈퇴가 진짜 다시 로그인 시켜볼 필요가 있나???
    }

    public UserEntity getUserInfo(String uid) {
        return mapper.getUserInfo(uid);
    }

    public void validateUser(SignUpReq p) {
        //회원가입 유효성 검사
        if (!Validator.isValidId(p.getUid())) {
            throw new UserValidNotSuccessException(UserErrorMessage.USER_ID_CHECK_MESSAGE);
        } else if (!Validator.isValidPassword(p.getUpw())) {
            throw new UserPasswordException(UserErrorMessage.USER_PASSWORD_CHECK_MESSAGE);
        } else if (!Validator.isValidEmail(p.getEmail())) {
            throw new UserEmailException(UserErrorMessage.USER_EMAIL_CHECK_MESSAGE);
        }
    }

    public int checkDuplicateEmail(SignUpReq p) {

        String userEmailInfo = null;
        try {
            userEmailInfo = mapper.getUserEmailInfo(p.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(UserErrorMessage.USER_EMAIL_SQLERROR_MESSAGE);
        }

        if (userEmailInfo == null) {
            return 1;   // 정상적 수행
        } else {
            return -5;  // 중복에러발생
        }
    }
}
