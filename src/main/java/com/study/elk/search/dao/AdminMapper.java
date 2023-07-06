package com.study.elk.search.dao;

import com.study.elk.search.dto.UserConvertList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<UserConvertList> userConvertList();
}
