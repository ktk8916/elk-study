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
                        <div>
                            <img src="https://petitions.assembly.go.kr/assets/img/gnb_assembly_logo.fd2631f3.png">
                        </div>
                        <div>
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">회원가입</a></li>
                                <li><a href="#">로그인</a></li>
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
                    <h2 style="font-size: 38px; font-weight: 700;">동의진행 청원</h2>
                    <p style="font-size: 21px; font-weight: 500;">당신의 제안, 우리의 동의, 함께 하는 입법</p>
                </section>
            </div>
        </div>
        <div class="center_area">


            <section class="detail_area">
                <h1 class="title">제발 제 조카를 성폭력 가해학생과 한 교실에 두지 말아 주세요 성폭력 가해학생의 교실분리 또는 전학 조치 의무화에 관한 청원</h1>

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
                        <p>발달장애를 가지고 있는 조카가 어느새 6학년이 되었습니다.
                            장애가 있음에도 불구하고 나름 학교생활을 잘 해 나가고 있는 게 기특했고 감사했습니다.
                            하지만 얼마 전부터 조카는 등교를 거부했고 그 이유가 같은 반 학생에게 지속적으로 성폭력을 당해 왔기 때문이라는 사실을 알게 되었습니다.

                            힘들고 긴 학교폭력위원회의 끝은 가해 학생의 '사회봉사 5시간'과 '신고(다른 학생들의 신고 사례 또한 있었습니다.) 및 고발 학생에 대한 접촉, 협박, 보복행위 금지' 처분이었습니다.
                            하지만 교실 분리 또는 전학에 대한 조치 없이 같은 교실 내에 있으면서 접촉 금지가 가능할 리 없습니다.
                            저희 가족은 전학까지는 아니더라도 교실 분리 만이라도 학교 측에 요청했지만 학교 측에서는 학교폭력위원회의 처분 결과에 해당 조치사항이 없기 때문에 이를 받아들여 주지 않고 있습니다.

                            이에, [학교폭력예방 및 대책에 관련 법률] 조치사항에서 가해자와 피해자의 분리 조치는 선택 또는 요청 항목이 아닌, 학교에서 이행해야 할 의무항목이 되도록 그리고 학교 측은 학교폭력위원회의 처분 결과에 상관없이 피해자에 대한 적극적인 보호를 취해주길 바라는 바입니다.

                            지금 이 글은 쓰는 중에도 손이 너무 떨립니다. 그래서 온 마음을 다 담지 못해 두서없이 써 내려진 것 같습니다.
                            읽어만 주셔도 감사를 드리며 청원에 동의까지 해 주신다면 정말 감사하겠습니다.

                            더 이상 성폭력 피해자들이 2차 피해 상황에 방치되지 않도록 도와주세요.</p>
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