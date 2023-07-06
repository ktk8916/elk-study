package com.study.elk.search.service;

import com.study.elk.search.dao.ConvertMapper;
import com.study.elk.search.dto.ConvertDto;
import com.study.elk.search.dto.UserConvertInfoDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConvertServrice {

    private final ConvertMapper convertMapper;

    public ConvertServrice(ConvertMapper convertMapper) {
        this.convertMapper = convertMapper;
    }

    public int convertToPoint(ConvertDto convertDto) {
        return convertMapper.convertToPoint(convertDto);
    }
    public int FindUserByAmount() {
        return convertMapper.FindUserByAmount();
    }
    public int FindUserByPoint() {
        return convertMapper.FindUserByPoint();
    }

    public UserConvertInfoDto findCovertUserInfo(Map<String, Integer> seqParams) {
        return convertMapper.findCovertUserInfo(seqParams);
    }

    public int userDepositUpdate(Map<String, Integer> userDepositUpdateParams) {
        return convertMapper.userDepositUpdate(userDepositUpdateParams);
    }

    public int adminDepositUpdate(int cash) {
        return convertMapper.adminDepositUpdate(cash);
    }

    public int userRequestConvertSuccess(int userSeq) {
        return convertMapper.userRequestConvertSuccess(userSeq);
    }
}
