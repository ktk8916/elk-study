package com.study.elk.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepositDao {
    void insertDeposit(DepositDto deposit);

    void updateDeposit(DepositDto deposit);

    DepositDto getDepositByUserSeq(int userSeq);

}
