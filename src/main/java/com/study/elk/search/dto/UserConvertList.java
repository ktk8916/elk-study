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
public class UserConvertList {
    private int convert_cash_to_point_id;
    private int user_seq;
    private int request_cash;
    private int convert_point;
    private String point_exchanges_date;
    private int point_exchanges_status;
    private String login_id;
    private String name;
}
