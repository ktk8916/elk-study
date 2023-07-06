package com.study.elk.user;

public class UserDto {
    private Integer userSeq;
    private String loginId;
    private String password;
    private String name;

    public UserDto(Integer userSeq, String loginId, String password, String name) {
        this.userSeq = userSeq;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
    }

    public Integer getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}