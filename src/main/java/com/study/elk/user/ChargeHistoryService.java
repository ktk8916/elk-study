package com.study.elk.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeHistoryService {
    @Autowired
    private  ChargeHistoryDao chargeHistoryDao;

    public ChargeHistoryService(ChargeHistoryDao chargeHistoryDao) {
        this.chargeHistoryDao = chargeHistoryDao;
    }

    public void insertChargeHistory(ChargeHistoryDto chargeHistory) {
        chargeHistoryDao.insertChargeHistory(chargeHistory);
    }

    public List<ChargeHistoryDto> getChargeHistoryByUserSeq(int userSeq) {
        return chargeHistoryDao.getChargeHistoryByUserSeq(userSeq);
    }

    public UserDepositDto getUserDeposit(int userSeq) {
        return chargeHistoryDao.getUserDeposit(userSeq);
    }
}