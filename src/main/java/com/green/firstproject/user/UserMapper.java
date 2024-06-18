package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int signUpUser(SignUpReq p);

    int updateUpw(ChangeUpwReq p);
    int deleteUserInfo(long userId);
    UserEntity getUserInfo(String uid);
    //user my page
    UserEntity getUserMyPage(long signedUserId);

    String getUserEmailInfo(String email);
}
