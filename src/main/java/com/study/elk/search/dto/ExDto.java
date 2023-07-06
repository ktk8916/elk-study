package com.study.elk.search.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExDto {

    private String index;
    private String field;
    private String keyword;
}
