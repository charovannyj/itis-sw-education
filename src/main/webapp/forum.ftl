<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <#--<script>
        $.get("forum", function(data) {
            var forums = data.forums; // получаем атрибут "forums" из ответа сервера
            $("#ajax-response").text(forums); // выводим значение атрибута в элемент
        });
    </script>-->
    <style>
        .card {
            margin-top: 20px;
            background: #cdf6ff;
        }
        .textarea {
            width: 50%;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid text-bg-warning p-3">
        <#--<a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>-->


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

<#--<div id="ajax-response">

</div>-->
<#--${forums}-->
<div class="row">
    <div class="col-md-6 offset-md-3">
        <form action="forum" method="post">
            <textarea class="textarea" name="message" placeholder="Введите сообщение" charset="UTF-8"></textarea>
            <input type="submit" charset="UTF-8">
        </form>
        <#list reviews as review>
            <div class="card">
                <div class="card-body">
                    <h6 class="card-title">${review.login_user} в ${review.time}</h6>
                    <p class="card-text">${review.content}</p>
                </div>
            </div>
        </#list>
    </div>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>