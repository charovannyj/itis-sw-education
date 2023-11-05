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
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid text-bg-warning p-3">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse " id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="/main" aria-current="page">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/education" aria-current="page" >Моё обучение</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/rating" aria-current="page">Отзывы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/forum" aria-current="page">Форум</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/profile" aria-current="page">Профиль</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/login" aria-current="page">Выход</a>
                </li>
            </ul>
        </div>
        <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container">
    <a href="/main"><img class="logo" src="logo.png" alt="Logo Image"></a>
    <p class="welcome-message">${name}, добро пожаловать на нашу платформу онлайн-образования!</p>
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
    <p class="name">Полное имя: ${name}</p>
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

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>