<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up Page</title>
</head>
<body>
<h1>Sign Up Page</h1>
<form action="/user/signup" method="post">
    <label for="loginId">Login ID:</label>
    <input type="text" id="loginId" name="loginId"><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br>

    <input type="submit" value="Sign Up">
</form>
</body>
</html>
