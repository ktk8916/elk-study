<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Charge History</title>
    <style>
        body {
            background-color: #F5F5F5;
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            border-bottom: 1px solid #CCCCCC;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<h1> 충전 내역 </h1>
<table>
    <tr>
        <th>순서</th>
        <th>충전한 금액</th>
    </tr>
    <c:forEach var="chargeHistory" items="${chargeHistoryList}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${chargeHistory.chargePrice}</td>
        </tr>
    </c:forEach>
    <tr>
        <td>내 잔고</td>
        <td>내 포인트</td>
    </tr>
    <tr>
        <td>${amount}</td>
        <td>${point}</td>
    </tr>
</table>
</body>
</html>