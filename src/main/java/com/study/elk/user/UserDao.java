package com.study.elk.user;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    int insert(SignupRequest request);
    UserDto getUserByLoginId(LoginRequest request);

    int insertWallet(int userSeq);
    DepositDto searchWallet(int userSeq);
}