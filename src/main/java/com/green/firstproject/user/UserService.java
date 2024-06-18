package com.green.firstproject.user;

import com.green.firstproject.common.CustomFileUtils;
import com.green.firstproject.user.check.Validator;
import com.green.firstproject.user.model.*;
import com.green.firstproject.user.userexception.*;
import com.green.firstproject.user.userexception.message.UserErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final CustomFileUtils utils;

    //회원가입
    @Transactional
    public int signUpUser(SignUpReq p) {
        String hashPass = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());

        p.setUpw(hashPass);

        int result = mapper.signUpUser(p);

        return result;
    }
    //유저 로그인
    public SignInRes signInUser(SignInReq p) {

        UserEntity user = mapper.getUserInfo(p.getUid());

        if (user == null) {
            throw new UserNotFoundException(UserErrorMessage.USER_NOT_FOUND_EXCEPTION);
        } else if (!BCrypt.checkpw(p.getUpw(), user.getUpw())) {
            throw new UserPasswordException(UserErrorMessage.USER_NOT_FOUND_USER_PASSWORD);
        }

        return SignInRes.builder()
               .userId(user.getUserId())
               .build();
    }
    // 비밀번호 변경
    public int updateUpw(ChangeUpwReq p) {
        UserEntity user = mapper.getUserInfo(p.getUid());
        // p.getUpw
        if (!BCrypt.checkpw(p.getUpw(), user.getUpw())) {
            throw new UserPasswordException(UserErrorMessage.USER_NOT_FOUND_USER_PASSWORD);
        }
        if (!Validator.isValidPassword(p.getUpw())) {
            throw new UserValidNotSuccessException(UserErrorMessage.USER_PASSWORD_CHECK_MESSAGE);
        }

        return mapper.updateUpw(p);
    }

    //유저삭제
    public int deleteUserInfo(long userId) {
        String shortPath = String.format("/user/%d", userId);
        utils.deleteFolder(shortPath);
        return mapper.deleteUserInfo(userId);
        //탈퇴가 진짜 다시 로그인 시켜볼 필요가 있나???
    }
    //유저 마이페이지
    public UserEntity getUserMyPage(long signedUserId) {
        return mapper.getUserMyPage(signedUserId);
    }

    //회원가입 유효성 검사
    public void validateUser(SignUpReq p) {

        if (!Validator.isValidId(p.getUid())) {
            throw new UserValidNotSuccessException(UserErrorMessage.USER_ID_CHECK_MESSAGE);
        } else if (!Validator.isValidPassword(p.getUpw())) {
            throw new UserPasswordException(UserErrorMessage.USER_PASSWORD_CHECK_MESSAGE);
        } else if (!Validator.isValidEmail(p.getEmail())) {
            throw new UserEmailException(UserErrorMessage.USER_EMAIL_CHECK_MESSAGE);
        }
    }
    //이메일 중복 검사
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

    //프론트 요청 uid->user PK 수정 중 쓰이지 않는 메소드
    /*
    public int searchUser(String uid){
        UserEntity user = mapper.getUserInfo(uid);

        int idCheck = 0;

        if (user != null) {
            idCheck = 0;
        }  else {
            idCheck = -1;
        }

        return idCheck;
    }*/
}
