package com.study.elk.Service;

import com.study.elk.dao.UserMapper;

import java.util.List;

public class PointService {

    UserMapper userMapper;

    public PointService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int UpdateWallet(int uid){
        return userMapper.UpdateWallet(uid);
    }

    public List<Object> WalletLog(int uid){return userMapper.WalletLog(uid);}
}
