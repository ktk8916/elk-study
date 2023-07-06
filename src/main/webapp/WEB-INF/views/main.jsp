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
        body, h1, h2, h3, h4, h5, h6, p, ol, ul {
            margin: 0;
            padding: 0;
            font-family: Pretendard;
        }

        /* Set default font size and family */
        body, button, input, select, textarea {
            font-size: 100%;
            font-family: inherit;
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


        header {
            margin-bottom: 15px;
        }

        .inner_background {
            width: 100%;
            height: 100vh;
            background-image: url("https://petitions.assembly.go.kr/assets/img/mainVisual01.6a05f050.jpg");
            background-size: cover;
        }

        .center_area {
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
    </style>
    <%--  <link rel="stylesheet" href="../style/common.css">--%>
    <%--  <link rel="stylesheet" href="../style/main.css">--%>
</head>
<body>
<main class="wrap">
    <div class="inner_background">
        <div class="center_area">

            <%@include file="header.jsp"%>

            <section class="mid_text_area">
                <h2>국민과 국회가 함께 만들어가는</h2>
                <p>국회참여 입법시스템</p>
            </section>
            <section class="btn_area">
                <div class="left_btn">
                    <div>
                        <img style="height: 50px;" src="https://petitions.assembly.go.kr/assets/img/main_icon_write.20321d03.png">
                    </div>
                    <p>청원하기</p>
                </div>
                <div class="right_btn">
                    <div>
                        <img style="height: 50px;" src="https://petitions.assembly.go.kr/assets/img/main_icon_agree.4907a534.png">
                    </div>
                    <p>동의하기</p>
                </div>
            </section>
            <section class="search_area">
                <form action="/search" method="get" class="input_wrap">
                    <input placeholder="검색어를 입력하세요." class="search_input" type="text" name="keyword"/>
                </form>
            </section>
        </div>
    </div>
</main>

</body>
</html>