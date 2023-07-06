package com.study.elk.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper

public interface UserMapper {

    int UpdateWallet(int uid);
    List<Object> WalletLog(int uid);
}
