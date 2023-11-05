<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">

<head>
    <link rel="stylesheet" type="text/css" href="login.css">
    <meta charset="UTF-8">
    <title>Login page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<form action="login" method="post">
    Login:
    <input type="text" name="login"/>
    <br>
    Password:
    <input type="password" name="password"/>
    <br>
    <input type="submit" value="Войти">

</form>
<#--<form action="passwordReset">
    <input type="submit" value="Забыли пароль?" id="forgot password">
</form>-->
<link rel="stylesheet" href="css/bootstrap.min.css">
</body>
</html>