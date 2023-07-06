<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.study.elk.dto.SearchResponseDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>국민청원</title>
    <style>
        /* Reset.css */

        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');
        @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&family=Noto+Sans+KR:wght@400;500;700&display=swap');
        @import url("https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.6/dist/web/static/pretendard.css");


        /* Remove default margin and padding */
        body, h1, h2, h3, h4, h5, h6, p, ol, ul, section {
            margin: 0;
            padding: 0;
            font-family: Pretendard;
            box-sizing: border-box;
        }

        /* Set default font size and family */
        body, button, input, select, textarea {
            font-size: 100%;
            font-family: inherit;
            box-sizing: border-box;
        }

        /* Remove list styles (bullets/numbers) */
        ol, ul {
            list-style: none;
        }

        /* Reset hyperlink styles */
        a {
            text-decoration: none;
            color: inherit;
        }

        /* Remove underline on linked images */
        a img {
            border: none;
        }

        /* Reset form element styles */
        button, input, select, textarea {
            margin: 0;
            border: none;
            outline: none;
        }

        div {
            box-sizing: border-box;
        }

        .wrap {

        }

        header {
            margin-bottom: 15px;
        }

        .inner_background {
            width: 100%;
            min-height: 100vh;
            background-image: url("https://petitions.assembly.go.kr/assets/img/mainVisual01.6a05f050.jpg");
            background-size: cover;
        }

        .inner_background_height {
            width: 100%;
            height: 400px;
            background-image: url("https://petitions.assembly.go.kr/assets/img/mainVisual01.6a05f050.jpg");
            background-size: cover;
            background-position: 50% 50%;
        }

        .center_area {
            width: 1100px;
            margin: 0 auto;
            padding-bottom: 40px;
        }

        .center_area_other {
            width: 1100px;
            margin: 0 auto;
        }

        .center_area .header_inner_wrap {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .center_area .header_inner_wrap ul {
            display: flex;
            gap: 20px;
        }

        .center_area .header_inner_wrap ul li a {
            color: #fff;
            text-shadow: 2px 1px 1px rgba(0,0,0,.4);
            font-weight: 400;
            font-size: 14px;
        }

        .center_area_other .header_inner_wrap {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .center_area_other .header_inner_wrap ul {
            display: flex;
            gap: 20px;
        }

        .center_area_other .header_inner_wrap ul li a {
            color: #fff;
            text-shadow: 2px 1px 1px rgba(0,0,0,.4);
            font-weight: 400;
            font-size: 14px;
        }

        .gnb {
            width: 100%;
            height: 65px;
            background: #ffffff;
            margin-bottom: 40px;
        }

        .gnb .gnb_wrap {
            display: flex;
            width: 100%;
            height: 100%;
        }

        .gnb .gnb_wrap .first_menu_img {
            width: 30%;
        }

        .gnb .gnb_wrap div {
            width: 17.5%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            border-right: 1px solid #ccc;
            font-weight: 600;
            color: #000;
            cursor: pointer;
        }

        .mid_text_area {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap: 10px;
            margin-bottom: 40px;
        }

        .mid_text_area h2 {
            font-size: 28px;
            font-weight: 600;
            color: #fff;
            text-shadow: 2px 1px 1px rgba(0,0,0,.4);
        }

        .mid_text_area p {
            font-size: 40px;
            font-weight: 600;
            color: #fff;
            text-shadow: 2px 1px 1px rgba(0,0,0,.4);
        }

        .btn_area {
            width: 500px;
            height: 60px;
            margin: 0 auto;
            display: flex;
            justify-content: space-around;
            align-items: center;
            margin-bottom: 40px;
        }

        .btn_area .left_btn, .btn_area .right_btn {
            width: calc(100% / 2 - 20px);
            height: 100%;
            background: linear-gradient(180deg,#05957c 1%,#016c5a);
            border-radius: 10px;
            padding: 10px 20px 10px 20px;
            display: flex;
            align-items: center;
            box-sizing: border-box;
            justify-content: space-around;
            font-size: 23px;
            font-weight: 600;
            color: #fff;
            cursor: pointer;
        }

        .search_area {
            width: 500px;
            height: 52px;
            margin: 0 auto;
        }

        .search_area .input_wrap {
            width: 100%;
            height: 100%;
            display: flex;
        }

        .search_area .input_wrap .search_input {
            width: 100%;
            height: 100%;
            border-radius: 10px;
            border: 3px solid #01a68a;
            text-align: center;
        }

        .search_area .input_wrap .search_input::placeholder {
            font-weight: 600;
            color: #000;
        }


        .search_area .input_wrap .search_img {
            width: 10%;
            height: 100%;
            border-radius: 10px;
            background: #01a68a;
        }

        .contents_wrap {
            width: 100%;
            background: #fff;
            padding: 15px;
            margin-bottom: 20px;
        }

        .contents_wrap .search_history_info_inner {
            padding: 5px 30px;
            border: 1px solid #7b7b7b;
            background: #f1f1f1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            gap: 10px;
        }

        .contents_wrap .search_history_info_inner div {
            padding: 5px 10px;
            display: flex;
            gap: 30px;
            align-items: center;
            background-color: #fff;
        }

        .contents_wrap .search_history_info_inner div > p {
            width: 12%;
            font-weight: 700;
        }

        .contents_wrap .search_history_info_inner div > p span {
            margin-right: 3px;
        }

        .contents_wrap .search_history_info_inner .history_inner {
            display: flex;
            gap: 10px;
        }

        .contents_wrap .search_history_info_inner .history_inner > div {
            background: #717171;
            color: #fff;
            padding: 4px 15px;
            border-radius: 15px;
            font-size: 14px;
            cursor: pointer;
        }

        .search_area_zone {
            width: 100%;
            background-color: #f4f4f4;
            padding: 15px;
            margin-bottom: 15px;
        }

        .search_area_zone .search_input {
            width: 360px;
            height: 45px;
            font-size: 17px;
            font-weight: 600;
            padding: 0 30px;
            border-radius: 10px;
            border: 3px solid #01a68a;
            text-align: center;
        }
        .search_area_zone .input_wrap {
            display: flex;
            align-items: center;
            justify-content: center;
            border-bottom: 1px solid #000;
            padding-bottom: 15px;
            font-weight: 600;
            margin-bottom: 15px;
        }

        .search_area_zone .input_wrap::placeholder {
            font-weight: 600;
            color: #000;
        }

        .search_area_zone .search_range {
            padding-left: 30px;
            display: flex;
            align-items: center;
        }

        .search_area_zone .search_range > p {
            margin-right: 20px;
        }

        .search_area_zone .search_range > p span {
            margin-right: 3px;
        }

        .search_area_zone .search_range .radio_area {
            margin-right: 15px;
        }
        .search_area_zone .search_range .radio_area input {
            cursor: pointer;
        }
        .search_area_zone .search_range .radio_area label {
            cursor: pointer;
        }

        .search_result_area {
            width: 100%;
            padding: 20px;
            background-color: #fff;
        }

        .search_result_area .info_text {
            margin-bottom: 30px;
        }

        .search_result_area .info_text .keyword {
            color: red;
            font-weight: 600;
            margin-right: 3px;
        }
        .search_result_area .info_text .type, .search_result_area .info_text .qty{
            font-weight: 600;
            margin-right: 3px;
        }

        .search_result_area .result_info_area {
            border-bottom: 1px solid #000;
            padding-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .search_result_area .result_info_area > p .qty {
            color: red;
            font-weight: 600;
            margin-right: 3px;
        }

        .search_result_area .result_info_area > div {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .result_area {
            padding: 15px;

            border-bottom: 1px solid #ccc;
        }

        .result_area .date {
            margin-bottom: 10px;
            font-size: 13px;
        }

        .result_area .title {
            padding: 8px 0;
            font-size: 16px;
            cursor: pointer;
        }


        .result_area .content {
            font-size: 14px;
            height:50px;
            text-overflow:ellipsis;
            word-wrap:break-word;
            display: -webkit-box;
            -webkit-line-clamp:3;
            -webkit-box-orient:vertical;
            overflow:hidden;
            cursor: pointer;
        }

        .result_area:hover .title {
            color: #01a68a;
        }

        .result_area:hover .content {
            color: #01a68a;
        }

    </style>
</head>
<body>
<main class="wrap">
    <div>
        <div class="inner_background_height">
            <div class="center_area_other">
                <header>
                    <div class="header_inner_wrap">
                        <div>
                            <img src="https://petitions.assembly.go.kr/assets/img/gnb_assembly_logo.fd2631f3.png">
                        </div>
                        <div>
                            <ul>
                                <li><a href="/main">Home</a></li>
                                <li><a href="/user/signup">회원가입</a></li>
                                <li><a href="/user/login">로그인</a></li>
                                <li><a href="#">FAQ</a></li>
                            </ul>
                        </div>
                    </div>
                </header>

                <section class="gnb">
                    <div class="gnb_wrap">
                        <div class="first_menu_img">
                            <img src="https://petitions.assembly.go.kr/assets/img/gnbLogo.3b00e93d.png">
                        </div>
                        <div><p>청원안내</p></div>
                        <div><p>동의진행 청원</p></div>
                        <div><p>동의종료 청원</p></div>
                        <div><p>위원부 회부 청원</p></div>
                    </div>
                </section>

                <section class="mid_text_area">
                    <h2 style="font-size: 38px; font-weight: 700;">청원검색</h2>
                    <p style="font-size: 21px; font-weight: 500;">국민과 국회가 함께 만들어가는 국민참여 입법시스템</p>
                </section>
            </div>

        </div>

        <section class="contents_wrap">
            <div class="center_area_other">
                <div class="search_history_info">
                    <div class="search_history_info_inner">
                        <div class="top_history">
                            <p><span>·</span>인기 검색어</p>
                            <%
                                List<String> popularKeyword = (List<String>)request.getAttribute("popularKeyword");
                                pageContext.setAttribute("popularKeyword", popularKeyword);
                            %>
                            <div class="history_inner">
                                <c:forEach var="keyword" items="${popularKeyword}">
                                    <div onclick="window.location.href='/search?keyword=${keyword}'"><c:out value="${keyword}" /></div>
                                </c:forEach>
                            </div>
                        </div>
<%--                        <div class="mid_history">--%>
<%--                            <p><span>·</span>내가 찾은 검색어</p>--%>
<%--                            <div class="history_inner">--%>
<%--                                <div>검색어1</div>--%>
<%--                                <div>검색어2</div>--%>
<%--                                <div>검색어3</div>--%>
<%--                                <div>검색어4</div>--%>
<%--                                <div>검색어5</div>--%>
<%--                                <div>검색어6</div>--%>
<%--                                <div>검색어7</div>--%>
<%--                                <div>검색어8</div>--%>
<%--                                <div>검색어9</div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="bot_history">
                            <p><span>·</span>연관검색어</p>
                            <div class="history_inner">
                                <%
                                    SearchResponseDto result = (SearchResponseDto) request.getAttribute("result");
                                    List<String> suggestWords = result.getSuggestWords();
                                    pageContext.setAttribute("suggestWords", suggestWords);
                                %>
                                <c:choose>
                                    <c:when test="${empty suggestWords}">
                                        <div>연관 검색어가 없습니다.</div>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="suggestWord" items="${suggestWords}">
                                            <div onclick="window.location.href='/search?keyword=${suggestWord}'"><c:out value="${suggestWord}" /></div>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </section>
        <div class="center_area">
            <div class="search_area_zone">
                <form action="/search" method="get" class="input_wrap">
                    <input name="keyword" placeholder="검색어를 입력하세요." class="search_input" type="text" />
                </form>
<%--                <div class="search_range">--%>
<%--                    <p><span>·</span>검색범위</p>--%>
<%--                    <div class="radio_area">--%>
<%--                        <input id="radio1" name="select" type="radio" />--%>
<%--                        <label for="radio1">제목+내용</label>--%>
<%--                    </div>--%>
<%--                    <div class="radio_area">--%>
<%--                        <input id="radio2" name="select" type="radio" />--%>
<%--                        <label for="radio2">제목</label>--%>
<%--                    </div>--%>
<%--                    <div class="radio_area">--%>
<%--                        <input id="radio3" name="select" type="radio" />--%>
<%--                        <label for="radio3" >내용</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
            <%
                List<Map<String, Object>> searchResult = result.getSearchResult();
                String keyword = (String)request.getAttribute("keyword");
                pageContext.setAttribute("searchResult", searchResult);
            %>

            <div class="search_result_area">
                <p class="info_text"><span class="keyword"><%=keyword%></span> 키워드로 검색한 결과 (총 <span class="qty">${searchResult.size()}</span>건) 입니다.</p>

                <div class="result_info_area">
                    <p class="qtyInfo">총 <span class="qty">${searchResult.size()}</span>건</p>
<%--                    <div>--%>
<%--                        <div class="radio_area">--%>
<%--                            <input id="radio5" name="select" type="radio" />--%>
<%--                            <label for="radio5">정확도순</label>--%>
<%--                        </div>--%>
<%--                        <div class="radio_area">--%>
<%--                            <input id="radio4" name="select" type="radio" />--%>
<%--                            <label for="radio4" >최신순</label>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>


                <c:forEach var="result" items="${searchResult}">
                    <div class="result_area" onclick="window.location.href='/petition/${result['petition_idx']}'">
                        <p class="date">등록일 : <span><c:out value="${result['end']}" /></span></p>
                        <h2 class="title"><c:out value="${result['title']}" /></h2>
                        <p class="content" ><c:out value="${result['content']}" /></p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>

</body>
</html>