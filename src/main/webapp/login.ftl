<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">

<head>
    <link rel="stylesheet" type="text/css" href="login.css">
    <meta charset="UTF-8">
    <title>Login page</title>
</head>
<body>

<form action="login" method="post">
    Login:
    <input type="text" name="login"/>
    <br>
    Password:
    <input type="password" name="password"/>
    <br>
    <input type="submit" value="login">
</form>

</body>
</html>