<!DOCTYPE html>
<html>
<#include "base.ftl">

<head>
    <link rel="stylesheet" type="text/css" href="start.css">

    <title>Простой HTML файл</title>
    <script>
        function goToLogin() {
            window.location.href = "/login";
        }

        function goToRegistration() {
            window.location.href = "/registration";
        }
    </script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<br>
Добро пожаловать на нашу платформу онлайн-образования. Выберите нужную категорию:

<button onclick="goToLogin()">У меня есть аккаунт</button>
<button onclick="goToRegistration()">Я тут новенький</button>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>