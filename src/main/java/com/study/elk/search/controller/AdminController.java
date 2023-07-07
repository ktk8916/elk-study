package com.study.elk.search.controller;

import com.study.elk.search.dto.UserConvertList;
import com.study.elk.search.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public ModelAndView userConvertList(ModelAndView mav, HttpSession session) {


        if (session.getAttribute("id") != null && session.getAttribute("id").equals("admin")) {
            // 현재 환전 진행중인 상태의 리스트..
            mav.addObject("userConvertList", adminService.userConvertList());
        } else {
            mav.setViewName("redirect:/main");
        }

        return mav;
    }
}
