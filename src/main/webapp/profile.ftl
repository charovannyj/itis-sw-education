<!DOCTYPE html>
<#include "base.ftl">

<html>
<head>
    <title>Buttons Example</title>
    <style>
        .container {
            display: flex;
            justify-content: space-between;
            flex-direction: row;
        }
        .profile {
            width: 100px;
            height: 100px;
            cursor: pointer;
        }
        .logo {
            width: 200px;
            cursor: pointer;
        }
        .welcome-message {
            text-align: center;
        }
    </style>
    <style>
        body {
            background-color: #f1f1f1;
            font-family: Arial, sans-serif;
        }

        .buttons-container {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            margin-top: 50px;
        }

        button {
            width: 200px;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="/main"><img class="logo" src="logo.png" alt="Logo Image"></a>
    <p class="welcome-message">${fullName}, добро пожаловать на нашу платформу онлайн-образования!</p>
    <img class="profile" src="profile.png" alt="Profile Image" onclick="openProfileOptions()">
    <div id="profileOptions" style="display: none;">
        <a href="/profile">Профиль</a>
        <a href="/start">Выход</a>
    </div>
</div>
<div class="buttons-container">
    <form method="post" action="/profile" enctype="multipart/form-data">
        <input type="text" name="newPassword" id="change-password">
        <button type="submit">Сменить пароль</button>
        <input type="file" name="newPhoto" id="add-photo">
        <button type="submit">Добавить фотографию</button>
    </form>
</div>
<div class="education-photo">
    <img>
</div>
<div class="data-profile">
    <p class="name">Полное имя: ${fullName}</p>
    <br>
    <p class="login">Логин: ${login}</p>
    <br>
    <p class="date">Дата рождения: ${date}</p>
    <br>
    <p class="position">Должность: ${position}</p>
    <br>
    <p class="gender">Пол: ${gender}</p>
    <br>
</div>
</body>
</html>