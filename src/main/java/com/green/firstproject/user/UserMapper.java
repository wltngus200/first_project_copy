package com.green.firstproject.user;

import com.green.firstproject.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int signUpUser(SignUpReq p);
    UserEntity signInUser(SignInReq p); //selectUserId

    int updateUpw(ChangeUpwReq p);
    int deleteUserInfo(long userId);
    UserEntity getUserInfo(long userId);

}
