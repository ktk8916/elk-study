package com.study.elk.controller;

import com.study.elk.Service.PetitionService;
import com.study.elk.Service.PointService;
import com.study.elk.domain.dto.Comment;
import com.study.elk.request.NonIdPetition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PetitionController {
    private final PetitionService petitionService;
    private final PointService pointService;

    public PetitionController(PetitionService petitionService, PointService pointService) {
        this.petitionService = petitionService;
        this.pointService = pointService;
    }


    @GetMapping("/petition/{idx}") // 글 처음 읽는 부분
    public ModelAndView readPetition(ModelAndView mav, @PathVariable("idx") int idx, @RequestParam("title") String title, @RequestParam("content") String content){

        // 그냥 테이블 아이디로 검색해야한다.
        System.out.println(idx);

        mav.addObject("idx",idx);
        List<Comment> comments = petitionService.readComment(idx);
        System.out.println(comments.size());


        mav.addObject("commentTable",comments);
        mav.addObject("title", title);
        mav.addObject("content", content);

        mav.setViewName("petitions"); // 보여줄 화면

        return mav;
    }


    @PostMapping("/comment") // 댓글 달기
    public ModelAndView writePetition(ModelAndView mav, HttpSession session,
                              @RequestParam(name = "idx", required = false)Integer idx,
                              @RequestParam(name = "content", required = false) String content){

       int userSeq = (int) session.getAttribute("userSeq");

        // 댓글을 넣는 곳

        Comment comment = new Comment(userSeq,content,idx);

        petitionService.insertComment(comment);



        mav.setViewName("redirect:/petition/" + idx);
        return mav;
    }

    @PostMapping("/delete")
    public ModelAndView deleteComment(ModelAndView mav,
                                      @RequestParam(name = "commentId")int commentId,
                                      @RequestParam(name = "petitionId")int idx){
        petitionService.deleteComment(commentId);

        mav.setViewName("redirect:/petition/" + idx);
        return mav;
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
//        Petitions petitions = new Petitions(nonIdPetition,id,tid);
//
//        petitionService.writePetition(petitions);

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

//        Likes likes = new Likes();
//        readWriteService.like(likes);
//
//        mav.setViewName("redirect:/main");

        return mav;

    }

}
