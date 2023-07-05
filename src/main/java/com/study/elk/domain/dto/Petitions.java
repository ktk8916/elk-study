package com.study.elk.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Petitions {
    private String title;
    private String content;
    private int likes;
    private int userId;
    private int tableId;


}
