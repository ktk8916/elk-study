package com.study.elk.search.service;

import com.study.elk.search.dao.ConvertMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    private final ConvertMapper convertMapper;

    public TransactionService(ConvertMapper convertMapper) {
        this.convertMapper = convertMapper;
    }

    @Transactional
    public void ConvertLogicalTransaction(int convertSeq, int requestCash) {
        // 유저의 환전상태를 완료로 바꿔주고..
        convertMapper.userRequestConvertSuccess(convertSeq);

        // 유저의 현금은 Admin 계정 잔고로 적재..
        convertMapper.adminDepositUpdate(requestCash);
    }

}
