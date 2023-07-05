package com.study.elk.search.dao;

import com.study.elk.search.dto.ConvertDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConvertMapper {
    int convertToPoint(ConvertDto convertDto);
}
