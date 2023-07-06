package com.study.elk.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChargeHistoryDao {
    private final SqlSession sqlSession;

    public ChargeHistoryDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insertChargeHistory(ChargeHistoryDto chargeHistory) {
        sqlSession.insert("insertChargeHistory", chargeHistory);
    }

    public List<ChargeHistoryDto> getChargeHistoryByUserSeq(int userSeq) {
        return sqlSession.selectList("getChargeHistoryByUserSeq", userSeq);
    }
}