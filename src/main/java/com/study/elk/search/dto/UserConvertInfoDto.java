package com.study.elk.search.dto;

import co.elastic.clients.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserConvertInfoDto {
    private int convert_cash_to_point_id;
    private int user_seq;
    private int request_cash;
    private int convert_point;
    private DateTime point_exchanges_date;
    private String point_exchanges_status;


}
