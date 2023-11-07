<!DOCTYPE html>
<html>
<#include "base.ftl">

<head>
    <#--<link rel="stylesheet" type="text/css" href="start.css">-->

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

<div class="d-flex justify-content-center align-items-center">
    <button onclick="goToLogin()" class="btn btn-lg">У меня есть аккаунт</button>
    <button onclick="goToRegistration()" class="btn btn-lg">Я тут новенький</button>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>