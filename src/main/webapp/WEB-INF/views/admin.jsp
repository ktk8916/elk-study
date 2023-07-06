<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ADMIN</title>
</head>
<body>
    <div style="width: 1024px; margin: 0 auto; display: flex; text-align: center; margin-bottom: 20px; font-size: 18px; font-weight: bold">
        <div style="width: 25%; height: 50px"><a style="display:block; width: 100%; display: flex; justify-content: center; align-content: center; line-height: 50px;" href="#">유저 포인트 환전 현황</a></div>
        <div style="width: 25%; height: 50px"><a style="display:block; width: 100%; display: flex; justify-content: center; align-content: center; line-height: 50px;" href="#">메뉴 1</a></div>
        <div style="width: 25%; height: 50px"><a style="display:block; width: 100%; display: flex; justify-content: center; align-content: center; line-height: 50px;" href="#">메뉴 2</a></div>
        <div style="width: 25%; height: 50px"><a style="display:block; width: 100%; display: flex; justify-content: center; align-content: center; line-height: 50px;" href="#">메뉴 3</a></div>
    </div>

    <div style="width: 1024px; margin: 0 auto; display: flex; text-align: center; margin-bottom: 10px;">
        <div style="width: calc(100% / 8);">환전 번호</div>
        <div style="width: calc(100% / 8);">유저 ID</div>
        <div style="width: calc(100% / 8);">유저 이름</div>
        <div style="width: calc(100% / 8);">요청 금액</div>
        <div style="width: calc(100% / 8);">환전 될 포인트</div>
        <div style="width: calc(100% / 8);">환전 신청 날짜</div>
        <div style="width: calc(100% / 8);">환전 상태</div>
    </div>
    <div style="width: 1024px; margin: 0 auto;">
        <c:forEach items="${userConvertList}" var = "convert">
            <div style="width: 100%; display: flex; text-align: center; margin-bottom: 7px;">
                <div style="width: calc(100% / 8);">${convert.convert_cash_to_point_id}</div>
                <div style="width: calc(100% / 8);">${convert.login_id}</div>
                <div style="width: calc(100% / 8);">${convert.name}</div>
                <div style="width: calc(100% / 8);">${convert.request_cash}</div>
                <div style="width: calc(100% / 8);">${convert.convert_point}</div>
                <div style="width: calc(100% / 8);">${convert.point_exchanges_date}</div>
                <div style="width: calc(100% / 8);">${convert.point_exchanges_status == 0 ? '요청중' : '완료'}</div>
                <c:if test="${convert.point_exchanges_status == 0}">
                    <div style="width: calc(100% / 8); display: flex; justify-content: center; align-items: center;">
                        <form action="/convertToPointOk?convertSeq=${convert.convert_cash_to_point_id}" method="post">
                            <input type="submit" value="승인" />
                        </form>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </div>
</body>
</html>