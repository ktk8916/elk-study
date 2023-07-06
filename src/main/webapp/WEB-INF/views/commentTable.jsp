<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
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

        .info {
            width: 100%;
            background: #f9f9f9;
            border: 1px solid #939393;
            border-radius: 5px;
        }
        .test{
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 0 20px;
            border-bottom: 1px solid #000000;
            border-right: 1px solid #000000;

        }
        .test2{
            width: 1000px;
            margin-left: 30px;
            border: 1px solid #000000;
        }
        .test3{
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 0 20px;
            border-bottom: 1px solid #000000;

        }



    </style>
</head>
<section class="detail_area">

<div class="info">
    <div class="test">
        <p >작성자</p>
        <p>내용</p>
    </div>
    <c:forEach items="${commentTable}" var = "commentTable">
        <div class="test">
            <p >${commentTable.name}</p>
            <p >${commentTable.comment}</p>
<%--            <td>${todo.createAt}</td>--%>
            <c:set var="id" value="${sessionScope.userSeq}"/>
            <c:if test="${id eq commentTable.userSeq}">
                <td >
                    <a href="/todo/update?todoid=${todo.id}"> 삭제</a>
                        <%-- <a href="/todo/update/${todo.id}"> 수정</a>--%>
                        <%--        이런 식으로도 사용할 수 있음.--%>
                </td>
            </c:if>
        </div>
    </c:forEach>

</div>

</section>
<div>
    <% int idx = (int) request.getAttribute("idx"); %>
    <form action="/comment" method="post">
        <input type="hidden"name="idx" value="<%=idx%>">
        <input class="test2" type="text" name="content" placeholder="댓글을 입력해주세요">
        <input type="submit">
    </form>
</div>

