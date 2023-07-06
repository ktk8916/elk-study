<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="header_inner_wrap">
        <div>
            <img src="https://petitions.assembly.go.kr/assets/img/gnb_assembly_logo.fd2631f3.png">
        </div>
        <div>
            <ul>
                <li><a href="/main">Home</a></li>

                <c:if test="${id == null}">
                    <li><a href="/user/signup">회원가입</a></li>
                    <li><a href="/user/login">로그인</a></li>
                </c:if>
                <c:if test="${id =! null}">
                    <li><a href="#">${userId} 님 환영해요</a></li>
                    <li><a href="/user/logout">로그아웃</a></li>
                </c:if>
                <li><a href="/user/coin">금액충전</a></li>
                <li><a href="/user/point">포인트환전</a></li>
                <li><a href="/user/info">내환전정보</a></li>
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