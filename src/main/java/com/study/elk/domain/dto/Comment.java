package com.study.elk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private int comment_id;
    private String name;
    private int user_seq;
    private String comment;
}
