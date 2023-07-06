<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
    <tr>
        <td>작성자</td>
        <td>comment</td>
        <td>삭제?</td>
    </tr>
    <c:forEach items="${commentTable}" var = "commentTable">
        <tr>
            <td>${commentTable.name}</td>
            <td>${commentTable.comment}</td>
<%--            <td>${todo.createAt}</td>--%>
            <c:set var="id" value="${sessionScope.id}"/>
            <c:if test="${id eq commentTable.user_seq}">
                <td>
                    <a href="/todo/update?todoid=${todo.id}"> 삭제</a>
                        <%-- <a href="/todo/update/${todo.id}"> 수정</a>--%>
                        <%--        이런 식으로도 사용할 수 있음.--%>
                </td>
            </c:if>
        </tr>
    </c:forEach>

</table>