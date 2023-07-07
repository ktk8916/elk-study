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

        /* Additional resets... */

        .wrap {

        }

        header {
            margin-bottom: 15px;
        }

        .inner_background {
            width: 100%;
            min-height: 100vh;
            background-image: url("https://petitions.assembly.go.kr/assets/img/topVisual02.e221416e.jpg");
            background-size: cover;
        }

        .inner_background_height {
            width: 100%;
            height: 400px;
            background-image: url("https://petitions.assembly.go.kr/assets/img/topVisual02.e221416e.jpg");
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

        .detail_area {
            width: 100%;
            background-color: #ffffff;
            padding: 30px;
            margin-bottom: 20px;
            display: flex;
            flex-direction: column;
        }

        .detail_area .title {

            font-size: 36px;
            font-weight: 700;
            margin-bottom: 30px;
        }

        .detail_area .info {
            width: 100%;
            background: #f9f9f9;
            border: 1px solid #939393;
            border-radius: 5px;
        }

        .detail_area .info > div {
            height: 55px;
        }

        .detail_area .info > div:nth-child(1) {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 0 20px;
            border-bottom: 1px solid #000000;
        }

        .detail_area .info > div:nth-child(1) p:nth-child(1) {
            padding-right: 20px;
            border-right: 1px solid #000000;
            width: 15%;
            font-size: 18px;
        }

        .detail_area .info > div:nth-child(1) p:nth-child(2) {
            font-size: 18px;
            font-weight: 700;
        }

        .detail_area .info > div:nth-child(1) p:nth-child(1) {
            padding-right: 20px;
            border-right: 1px solid #000000;
        }

        .detail_area .info > div:nth-child(2) {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 0 20px;
            border-bottom: 1px solid #000000;
        }

        .detail_area .info > div:nth-child(2) .inner {
            display: flex;
            gap: 20px;
            width: 50%;
        }

        .detail_area .info > div:nth-child(2) .inner p:nth-child(1) {
            padding-right: 20px;
            border-right: 1px solid #000000;
            width: 30%;
            font-size: 18px;
        }

        .detail_area .info > div:nth-child(2) .inner p:nth-child(2) {
            font-size: 18px;
            font-weight: 700;
        }

        .detail_area .info > div:nth-child(3) {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 0 20px;
        }

        .detail_area .info > div:nth-child(3) .inner {
            display: flex;
            gap: 20px;
            width: 50%;
        }

        .detail_area .info > div:nth-child(3) .inner p:nth-child(1) {
            padding-right: 20px;
            border-right: 1px solid #000000;
            width: 30%;
            font-size: 18px;
        }

        .detail_area .info > div:nth-child(3) .inner p:nth-child(2) {
            font-weight: 700;
            font-size: 18px;
        }
        .detail_area .info > div:nth-child(3) .inner p:nth-child(2) span {
            color: red;
            margin-right: 3px;
        }

        .detail_info {
            padding: 15px;
        }

        .detail_info > div {
            padding: 20px;
            display: flex;
        }

        .detail_info > div p:nth-child(1) {
            width: 15%;
            padding-right: 20px;
            border-right: 1px solid #ccc;
        }

        .detail_info > div p:nth-child(2) {
            width: 85%;
            padding-left: 20px;
        }

        .detail_info .mid {
            letter-spacing: 1px;
            line-height: 27px;
        }

        .detail_info .bot {
            letter-spacing: 1px;
            line-height: 27px;
        }

    </style>
</head>
<body>
<main class="wrap">
    <div>
        <div class="inner_background_height">
            <div class="center_area">
                <header>
                    <div class="header_inner_wrap">
                        <div onclick="window.location.href='/main'">
                            <img src="https://petitions.assembly.go.kr/assets/img/gnb_assembly_logo.fd2631f3.png">
                        </div>
                        <div>
                            <ul>
                                <li><a href="/main">Home</a></li>

                                <%-- JSP 태그 대신 JavaScript 조건문 사용 --%>
                                <script>
                                  if (${id == null}) {
                                    document.write('<li><a href="/user/signup">회원가입</a></li>');
                                    document.write('<li><a href="/user/login">로그인</a></li>');
                                  } else {
                                    document.write('<li><a href="#">${userId} 님 환영해요</a></li>');
                                    document.write('<li><a href="/user/logout">로그아웃</a></li>');
                                    document.write('<li><a href="/user/coin">금액충전</a></li>');
                                    document.write('<li><a href="/user/point">포인트환전</a></li>');
                                    document.write('<li><a href="/user/info">내환전정보</a></li>');
                                  }
                                </script>
                            </ul>
                        </div>
                    </div>
                </header>

                <section class="gnb">
                    <div class="gnb_wrap">
                        <div class="first_menu_img" onclick="window.location.href='/main'">
                            <img src="https://petitions.assembly.go.kr/assets/img/gnbLogo.3b00e93d.png">
                        </div>
                        <div><p>청원안내</p></div>
                        <div><p>동의진행 청원</p></div>
                        <div><p>동의종료 청원</p></div>
                        <div><p>위원부 회부 청원</p></div>
                    </div>
                </section>

                <section class="mid_text_area">
                    <h2 style="font-size: 38px; font-weight: 700;">동의진행 청원</h2>
                    <p style="font-size: 21px; font-weight: 500;">당신의 제안, 우리의 동의, 함께 하는 입법</p>
                </section>
            </div>
        </div>
        <div class="center_area">


            <section class="detail_area">
                <h1 class="title">${title}</h1>

                <div class="info">
                    <div>
                        <p>청원분야</p>
                        <p>교육</p>
                    </div>
                </div>

                <section class="detail_info">
                    <div class="top">
                        <p>청원인</p>
                        <p>익명</p>
                    </div>
                    <div class="bot">
                        <p>청원의 내용</p>
                        <p>${content}</p>
                    </div>
                </section>
            </section>

            <div>
                <%@ include file="commentTable.jsp"%>
            </div>
        </div>
    </div>
</main>

</body>
</html>