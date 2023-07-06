package com.study.elk.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;
    private final DepositDao depositDao;


    @Autowired
    public UserService(UserDao userDao, DepositDao depositDao) {
        this.userDao = userDao;
        this.depositDao = depositDao;
    }

    public boolean signup(SignupRequest request) {
        return userDao.insert(request);
    }



    public UserDto login(LoginRequest request) {
        return userDao.getUserByLoginId(request);
    }

    public void insertBalance(int userSeq, int amount) {

        DepositDto deposit = new DepositDto();
        deposit.setUserSeq(userSeq);
        deposit.setAmount(amount);
        depositDao.insertDeposit(deposit);
          // 잔고 입력 성공
    }
}