<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>돈 충전</title>
    <style>
        @font-face {
            font-family: 'SBAggroB';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        .coin-form {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
            border: 1px solid #ccc;
            border-radius: 5px;
            justify-content: center;
            align-items: center;
            height: 30vh; /* 폼 컨테이너의 높이를 조정해주세요. */
        }

        .coin-form h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .coin-form input[type="text"],
        .coin-form input[type="number"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .coin-form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: red;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .coin-form input[type="submit"]:hover {
            background-color: red;
        }

        .coin-form .success-message {
            color: red;
            margin-bottom: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>얼마충전할래</h1>
<form action="/user/coin" method="post">
    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount" required>
    <br>
    <input type="submit" value="Charge">
</form>
</body>
</html>