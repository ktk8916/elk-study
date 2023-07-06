package com.study.elk.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ChargeHistoryService chargeHistoryService;

    public UserController(UserService userService, ChargeHistoryService chargeHistoryService) {
        this.userService = userService;
        this.chargeHistoryService = chargeHistoryService;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());

        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("id", null);
        return "redirect:/main";
    }

    @GetMapping("/signup")
    public String getSignup(Model model) {
        return "signup";
    }

    @GetMapping("/update")
    public ModelAndView showUpdatePage(HttpSession session) {
        ModelAndView mav = new ModelAndView("userupdate");
        Integer id = (Integer) session.getAttribute("id");
        mav.addObject("id", id);
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@ModelAttribute("loginRequest") LoginRequest request, ModelAndView mav, HttpSession session) {
        UserDto login = userService.login(request);
        System.out.println(login.getLoginId());
        if (login != null) {
            session.setAttribute("id", login.getLoginId());
            session.setAttribute("userId", login.getLoginId());
            session.setAttribute("userSeq", login.getUserSeq());
            session.setAttribute("uname", login.getName());
            mav.setViewName("redirect:/main");
        } else {
            mav.setViewName("redirect:/user/login");
        }

        return mav;
    }

    @PostMapping("/signup")
    public ModelAndView signup(
            @ModelAttribute("signupRequest") SignupRequest request,
            ModelAndView mav
    ) {
        if (userService.signup(request)) {
            mav.setViewName("redirect:/user/login");
        } else {
            mav.setViewName("redirect:/user/signup");
        }
        return mav;
    }
    @GetMapping("/coin")
    public String getCoinPage() {
        return "/coin";
    }

    @GetMapping("/point")
    public String getConvertPage() {
        return "/convert";
    }


    @PostMapping("/coin")
    public ModelAndView insertBalance(@RequestParam("amount") int amount, HttpSession session) {

        int result = userService.insertBalance((int) session.getAttribute("userSeq"), amount);

        if (result == 1) {
            // 충전한 잔액 + 원래 잔액 더해서 노출 해주자..
        }


        ModelAndView mav = new ModelAndView("redirect:/main");

        return mav;
    }
    @GetMapping("/info")
    public ModelAndView showUserInfo(HttpSession session) {
        ModelAndView mav = new ModelAndView("info");

        Integer userSeq = (Integer) session.getAttribute("userSeq");

        List<ChargeHistoryDto> chargeHistoryList = chargeHistoryService.getChargeHistoryByUserSeq(userSeq);
        UserDepositDto userDepositDto = chargeHistoryService.getUserDeposit(userSeq);


        mav.addObject("id", session.getAttribute("id"));
        mav.addObject("uname", session.getAttribute("uname"));
        mav.addObject("chargeHistoryList", chargeHistoryList);
        mav.addObject("amount", userDepositDto.getAmount());
        mav.addObject("point", userDepositDto.getPoint());

        return mav;
    }
}
