package com.study.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MatchQueryDto {

    private String index;
    private String field;
    private String keyword;
}
