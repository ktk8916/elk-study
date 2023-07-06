package com.study.elk.search.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConvertDto {
    private String userId;
    private int userSeq;
    private int userRequestCash;
    private int userPoint;
}
