package com.study.elk.search.dao;

import com.study.elk.search.dto.ConvertDto;
import com.study.elk.search.dto.UserConvertInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ConvertMapper {
    int convertToPoint(ConvertDto convertDto);
    int FindUserByAmount();
    int FindUserByPoint();
    UserConvertInfoDto findCovertUserInfo(Map<String, Integer> seqParams);
    int userDepositUpdate(Map<String, Integer> userDepositUpdateParams);
    int adminDepositUpdate(int cash);
    int userRequestConvertSuccess(int convertSeq);
}
