<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Charge History</title>
</head>
<body>
<h1>Charge History</h1>

<table>
    <tr>

        <th>User Seq</th>
        <th>Charge Price</th>

    </tr>
    <c:forEach var="chargeHistory" items="${chargeHistoryList}">
        <tr>

            <td>${chargeHistory.userSeq}</td>
            <td>${chargeHistory.chargePrice}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>