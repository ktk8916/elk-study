package com.study.elk.controller;

import com.study.elk.Service.ReadWriteService;
import com.study.elk.Service.PointService;
import com.study.elk.Service.PetitionService;
import com.study.elk.domain.dto.Comment;
import com.study.elk.domain.dto.Likes;
import com.study.elk.domain.dto.Petitions;
import com.study.elk.request.NonIdPetition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PetitionController {
    PetitionService petitionService;

    ReadWriteService readWriteService;
    PointService pointService;



    @GetMapping("/petition/1") // 글 처음 읽는 부분
    public ModelAndView readPetition(ModelAndView mav,@RequestParam(name = "tid")int tid){

        // 그냥 테이블 아이디로 검색해야한다.

        mav.addObject("petitions",readWriteService.readForEdit(tid));
        mav.addObject("commentTable",petitionService.readComment(tid));

        mav.setViewName("petitions"); // 보여줄 화면

        return mav;
    }


    @GetMapping("/petition/2") // 글 수정 및 작성
    public void writePetition(ModelAndView mav, HttpSession session,
                                      @RequestParam(name = "tid", required = false)Integer tid
                                      ){
        /*TODO 여기선 이전에 내가 썼던 글을 읽어와야함.
         * 그것을 하기위해선 이전페이지에서 글 ID를 넘겨줄 수있어야함
         * 이것을 수정을 누르면 get으로 글 페이지를 넘겨받을 수
         * 유저 아이디는 이미 있음
         * 그것으로 내가 쓴 글을 찾아서 읽어와야함.
         * 그리고 그것을 SET 해두고, 페이지를 보여줄 때 같이 보여주어야함.
         *
         * */
         // 글 읽어오기
        // Integer null 로 하자.
        System.out.println("tid = " + tid); // 빈공간일때 얘가 뭔지 찍어봐야함

        session.getAttribute("uid");

        // 이전 페이지에서 읽어올 때 uid랑 지금 uid 비교해야함.
        if(tid != null){
         //uid랑 글 id로 검색을 해야한다.
        mav.addObject("petitions",readWriteService.readForEdit(tid));
        }

//        mav.setViewName(); // jsp 이름 넣어야함.
//
//        return mav;

    }

    @PostMapping("/petition/2")
    public void requestPetition(ModelAndView mav, HttpSession session,
                                        @ModelAttribute NonIdPetition nonIdPetition,
                                            @RequestParam(name = "tableId",required = false)Integer tid){
        /*TODO 청원을 올리러 Submit 을 한 상황.
         * 받아야할 데이터 :
         * 세션에 있는 아이디로
         * 유저테이블 + 잔고테이블을 조인한것을 where에 세션 아이디를 걸어서 찾음
         */
        // 밑에 두줄은 편의상 넣어둔 것. 수정해야함.
        String point =(String) session.getAttribute("point");
        int id = (Integer) session.getAttribute("uid");

        //일단 세션에 있는 것을 받아와서 쓰지만, 나중에는 Redis 에 있는 데이터를 사용할 예정.
        // 글 올리는 서비스가 필요하다
        // 유저 아이디를 들고가야하고,
        // 포인트를 업데이트 하는 서비스가 필요하다.
        // 현재 포인트를 들고가야하고, 유저 아이디를 들고가야한다.
        Petitions petitions = new Petitions(nonIdPetition,id,tid);

        petitionService.writePetition(petitions);

        // 참고로 업데이트가 되었을 때 월렛이 작동해야하는데,
        // 여기서 문제는 글작성이 완료 되었지만 도중에 프로그램 문제로 월렛은 작동하지 않은 경우가 문제이다.
        // 이 경우엔 내가 가지고 있는 포인트 로그를 비교하여, 현재 갖고 있는 포인트가 맞는지 검사해야한다.



//        mav.setViewName(); //보여줄 페이지 이름, 아마도 메인
//
//        return mav;
    }

    @PostMapping("/petition/3")
    public ModelAndView like(ModelAndView mav, HttpSession session){

        int uid = (int) session.getAttribute("id");

        Likes likes = new Likes();
        readWriteService.like(likes);

        mav.setViewName("redirect:/main");

        return mav;

    }
}
