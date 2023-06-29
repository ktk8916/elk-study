package com.study.elk.user.dto;

import com.study.elk.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JoinDto {

    private String name;

    public User toEntity(){
        return User
                .builder()
                .name(this.name)
                .build();
    }
}
