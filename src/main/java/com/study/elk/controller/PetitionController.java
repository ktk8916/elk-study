package com.study.elk.controller;

import com.study.elk.Service.PetitionService;
import com.study.elk.Service.PointService;
import com.study.elk.Service.WriteService;
import com.study.elk.domain.dto.Likes;
import com.study.elk.domain.dto.Petitions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class PetitionController {
    WriteService writeService;

    PetitionService petitionService;
    PointService pointService;


    @GetMapping("/petition/1")
    public ModelAndView viewPetition(ModelAndView mav, HttpSession session){
        /*TODO 여기선 이전에 내가 썼던 글을 읽어와야함.
         * 그것을 하기위해선 이전페이지에서 글 ID를 넘겨줄 수있어야함
         * 이것을 수정을 누르면 get으로 글 페이지를 넘겨받을 수
         * 유저 아이디는 이미 있음
         * 그것으로 내가 쓴 글을 찾아서 읽어와야함.
         * 그리고 그것을 SET 해두고, 페이지를 보여줄 때 같이 보여주어야함.
         *
         * */
         // 글 읽어오기
        session.getAttribute("uid");

        Petitions petitions = petitionService.readPetition(); //uid랑 글 id로 검색을 해야한다.
        if(petitions != null){
            mav.addObject("petitions",petitions);
        }

        mav.setViewName(); // jsp 이름 넣어야함.

        return mav;

    }

    @PostMapping("/petition/1")
    public ModelAndView requestPetition(ModelAndView mav, HttpSession session){
        /*TODO 청원을 올리러 Submit 을 한 상황.
         * 받아야할 데이터 :
         * 세션에 있는 아이디로
         * 유저테이블 + 잔고테이블을 조인한것을 where에 세션 아이디를 걸어서 찾음
         */
        String point =(String) session.getAttribute("point");
        int id = (Integer) session.getAttribute("uid");

        //일단 세션에 있는 것을 받아와서 쓰지만, 나중에는 Redis 에 있는 데이터를 사용할 예정.
        // 글 올리는 서비스가 필요하다
        // 유저 아이디를 들고가야하고,
        // 포인트를 업데이트 하는 서비스가 필요하다.
        // 현재 포인트를 들고가야하고, 유저 아이디를 들고가야한다.
        Petitions petitions = null;

        writeService.writePetition(petitions);

        // 참고로 업데이트가 되었을 때 월렛이 작동해야하는데,
        // 여기서 문제는 글작성이 완료 되었지만 도중에 프로그램 문제로 월렛은 작동하지 않은 경우가 문제이다.
        // 이 경우엔 내가 가지고 있는 포인트 로그를 비교하여, 현재 갖고 있는 포인트가 맞는지 검사해야한다.

        mav.setViewName(); //보여줄 페이지 이름, 아마도 메인
        return mav;
    }

    @PostMapping("/petition/2")
    public ModelAndView like(ModelAndView mav, HttpSession session){

        int uid = (int) session.getAttribute("id");

        Likes likes = new Likes();
        petitionService.like(likes);

        mav.setViewName("redirect:/main");
        return mav;
    }
}
