package com.study.elk.search.service;

import com.study.elk.search.dao.ConvertMapper;
import com.study.elk.search.dto.ConvertDto;
import org.springframework.stereotype.Service;

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
}
