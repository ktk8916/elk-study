<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Charge History</title>
</head>
<body>
<h1>충전내역</h1>

<table>
    <tr>
        <th>유저 번호</th>
        <th>충전 금액</th>
    </tr>
    <c:forEach var="chargeHistory" items="${chargeHistoryList}">
        <tr>
            <td>${chargeHistory.userSeq}</td>
            <td>${chargeHistory.chargePrice}</td>
        </tr>
    </c:forEach>
</table>

<div>
    <h3>내 잔고</h3>
    <h3>${amount}</h3>
</div>
<div>
    <h3>내 포인트</h3>
    <h3>${point}</h3>
</div>
</body>
</html>