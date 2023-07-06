package com.study.elk.user;

public class DepositDto {
    private int petitionId;
    private int amount;
    private int userSeq;
    private int point;

    public int getPetitionId() {
        return petitionId;
    }

    public void setPetitionId(int petitionId) {
        this.petitionId = petitionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
