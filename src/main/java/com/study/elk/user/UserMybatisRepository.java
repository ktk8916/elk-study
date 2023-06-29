package com.study.elk.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMybatisRepository extends UserRepository {
    void save(User user);
}
