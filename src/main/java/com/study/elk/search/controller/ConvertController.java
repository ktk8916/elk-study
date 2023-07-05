package com.study.elk.search.controller;

import com.study.elk.search.dto.ConvertDto;
import com.study.elk.search.service.ConvertServrice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ConvertController {

    private final ConvertServrice convertServrice;

    public ConvertController(ConvertServrice convertServrice) {
        this.convertServrice = convertServrice;
    }

    @PostMapping ("/convertToPoint")
    public void convertToPoint(HttpSession session, @RequestParam int requestCash){

        // 포인트 환전을 요청한 ID, seq, 환전 요청한 금액(현금).. 으로 dto 용 객체 생성..
        ConvertDto convertDto = ConvertDto.builder().userId("test").userSeq(3).userRequestCash(requestCash).userPoint((int) (requestCash * 0.9)).build();

        // 유저 현금 -> 포인트 환전 신청.. default status == 0 (환전 대기 상태)
        convertServrice.convertToPoint(convertDto);
    }

    @PostMapping("/convertToPointOk")
    public void convertToPointOk() {

        // 관리자가 환전 승인을 누른 시나리오..
        int convertSeq = 3;

        // 유저가 환전 신청한 금액을 확인후.. 잔고에서 차감 하면서 동시에.. 포인트 추가..

//        Map<String, Object> params = new HashMap<>();
//        convertServrice.userRequestConvertInfo(convertSeq);
//
//        params.put("amountDecrement", 100);
//        params.put("pointIncrement", 100);
//        params.put("id", yourRecordId);



    }
}
