package com.study.elk.Service;

import com.study.elk.dao.UserMapper;

public class PointService {

    UserMapper userMapper;


    public int UpdateWallet(){
        return userMapper.UpdateWallet();
    }
}
