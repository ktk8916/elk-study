package com.study.elk.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;
    private final DepositDao depositDao;
    private final ChargeHistoryDao chargeHistoryDao;


    @Autowired
    public UserService(UserDao userDao, DepositDao depositDao, ChargeHistoryDao chargeHistoryDao) {
        this.userDao = userDao;
        this.depositDao = depositDao;
        this.chargeHistoryDao = chargeHistoryDao;
    }
@Transactional
    public boolean signup(SignupRequest request) {
        int userSeq = userDao.insert(request);

        if(userSeq != 0){
            return true;
        }
        return false;
    }

    public int insertWallet(int userSeq){return userDao.insertWallet(userSeq);}

    public UserDto login(LoginRequest request) {
        UserDto userByLoginId = userDao.getUserByLoginId(request);

        DepositDto depositDto = userDao.searchWallet(userByLoginId.getUserSeq());

        if(depositDto == null) {
            userDao.insertWallet(userByLoginId.getUserSeq());
        }

        return userByLoginId;
    }

    public int insertBalance(int userSeq, int amount) {

        DepositDto deposit = new DepositDto();

        deposit.setUserSeq(userSeq);
        deposit.setAmount(amount);

        ChargeHistoryDto chargeHistory = new ChargeHistoryDto(userSeq, amount);

        if (depositDao.insertDeposit(deposit) == 1 && chargeHistoryDao.insertChargeHistory(chargeHistory) ==1) {
            return 1;
        }

         return 0;
    }
}