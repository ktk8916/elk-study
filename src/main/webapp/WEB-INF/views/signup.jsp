<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            background-color: #F5F5F5;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #FFFFFF;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            border-radius: 4px;
            margin-top: 100px;
        }

        h3 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: 95%;
            padding: 8px;
            border: 1px solid #CCCCCC;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>회원 가입</h3>
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

