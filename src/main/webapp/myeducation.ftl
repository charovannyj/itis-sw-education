<!DOCTYPE html>
<html>
<#include "base.ftl">

<head>
    <title>Buttons Example</title>
    <link rel="stylesheet" type="text/css" href="myeducation.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>
        .card {
            margin-top: 20px;
            background: #cdf6ff;
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

<div class="row">
    <div class="col-md-6 offset-md-3">
        <#list courses as course>
            <div class="card">
                <div class="card-body">
                    <h6 class="card-title">${course.subject} ${course.area}</h6>
                    <p class="card-text">Преподаватель: ${course.name}<br>Цена: ${course.price}
                    <br>Длительность курса: ${course.duration}</p>
                </div>
            </div>
        </#list>
    </div>
</div>
<#--<div class="buttons-container">
    <button class="schedule" id="ajax-button-schedule">Расписание</button>
    <button class="home-tasks" id="ajax-button-home-tasks">Домашние задания</button>
    <button class="statistics" id="ajax-button-statistics">Статистика</button>
</div>
<div id="ajax-response">

</div>-->

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>