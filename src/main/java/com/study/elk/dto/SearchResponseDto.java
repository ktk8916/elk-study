package com.study.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class SearchResponseDto {

    List<Map<String, Object>> searchResult;
    List<String> suggestWords;
}
