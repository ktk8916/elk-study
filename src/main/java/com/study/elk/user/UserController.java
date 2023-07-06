package com.study.elk.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
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
    public ModelAndView postLogin(
            @ModelAttribute("loginRequest") LoginRequest request,
            ModelAndView mav,
            HttpSession session
    ) {
        UserDto login = userService.login(request);
        if (login != null) {
            session.setAttribute("id", login.getLoginId());
            session.setAttribute("userSeq", login.getUserSeq());
            session.setAttribute("uname", login.getName());
            mav.setViewName("redirect:/user/coin");
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
    @PostMapping("/coin")
    public ModelAndView insertBalance(
            @RequestParam("amount") int amount, HttpSession session
    ) {
        System.out.println( session.getAttribute("userSeq"));
        userService.insertBalance((int) session.getAttribute("userSeq"), amount);
        ModelAndView mav = new ModelAndView("redirect:/user/info"); // 잔고 삽입 후 리다이렉트할 페이지 설정
        return mav;
    }
    }

//    @PostMapping("/update")
//    public ModelAndView updateData(
//            @ModelAttribute UserUpdateRequest request,
//            HttpSession session,
//            ModelAndView mav
//    ) {
//        //  user seq 를 조건으로 user 테이블이랑 deposit 테이블을 조인해서 내 잔고를 찾아낸다..
//        // 내가 입력한 금액을 해당 잔고에 추가 시키고 다시 집어넣음. 성공했다는 결과를 줄거임..
//
//        // 위에것이 완료가 되었다면
//        // user 테이블이랑 충전내역 테이블의 user_seq 부분에 해당 유저의 seq를 같이 넣고 나머지 정보랑 insert..
//
//        Integer seq = (Integer) session.getAttribute("seq");
//
//        UserUpdate dto = request.toDto(id);
//        userService.update(dto);
//        mav.setViewName("redirect:/user/login");
//
//        return mav;
//    }