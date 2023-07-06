package com.study.elk.search.controller;

import com.study.elk.search.dto.ConvertDto;
import com.study.elk.search.dto.UserConvertInfoDto;
import com.study.elk.search.service.ConvertServrice;
import com.study.elk.search.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ConvertController {

    private final ConvertServrice convertServrice;

    private final TransactionService transactionService;

    public ConvertController(ConvertServrice convertServrice, TransactionService transactionService) {
        this.convertServrice = convertServrice;
        this.transactionService = transactionService;
    }

    @PostMapping ("/convertToPoint")
    public String convertToPoint(HttpSession session, @RequestParam int requestCash){

        int userSeq = (int) session.getAttribute("userSeq");

        // 포인트 환전을 요청한 ID, seq, 환전 요청한 금액(현금).. 으로 dto 용 객체 생성..
        ConvertDto convertDto = ConvertDto.builder().userId("test").userSeq(userSeq).userRequestCash(requestCash).userPoint((int) (requestCash * 0.9)).build();

        // 유저 현금 -> 포인트 환전 신청.. default status == 0 (환전 대기 상태)
        convertServrice.convertToPoint(convertDto);

        return "main";
    }

    @PostMapping("/convertToPointOk")
    public String convertToPointOk(@RequestParam int convertSeq, HttpSession session) {
        // 관리자가 환전 승인을 누른 시나리오..
        Map<String, Integer> seqParams = new HashMap<>();
        int userSeq = (int) session.getAttribute("userSeq");
        seqParams.put("userSeq", userSeq);
        seqParams.put("convertSeq", convertSeq);

        // 유저가 환전 신청한 금액을 확인후.. 잔고에서 차감 하면서 동시에.. 포인트 추가..
        UserConvertInfoDto userConvertInfoDto = convertServrice.findCovertUserInfo(seqParams);

        // 유저가 환전 신청한 금액 만큼 해당 유저의 잔고 차감 후.. 동시에 포인트 환전액 추가..
        Map<String, Integer> userDepositUpdateParams = new HashMap<>();

        userDepositUpdateParams.put("amountDecrement", userConvertInfoDto.getRequest_cash());
        userDepositUpdateParams.put("pointIncrement", userConvertInfoDto.getConvert_point());
        userDepositUpdateParams.put("userSeq", userConvertInfoDto.getUser_seq());

        int result = convertServrice.userDepositUpdate(userDepositUpdateParams);

        // 유저 환전 성공 시..
        if (result == 1) {
            // 유저의 환전상태를 바꿔주고.. admin 계정에 잔고를 추가해주는 logic... transaction 때문에 빼놓음..
            transactionService.ConvertLogicalTransaction(convertSeq, userConvertInfoDto.getRequest_cash());
        }

        return "redirect:/admin";
    }
}
