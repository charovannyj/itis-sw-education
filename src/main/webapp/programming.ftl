<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 20px;
        }
    </style>
    <style>
        .center {
            text-align: center;
        }
    </style>
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
<div class="center">
    <h1>${subject}</h1>
</div>
<div class="container">
    <div class="row justify-content-around row-cols-1 row-cols-md-2 g-4">
        <div class="col">
            <div class="card">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${names[0]} ${areas[0]}</h5>
                    <p class="card-text">${contents[0]}</p>
                    <a href="/congratulation?name=${names[0]}&area=${areas[0]}&subject=${subject}" class="btn btn-primary">Записаться на курс</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${names[1]} ${areas[1]}</h5>
                    <p class="card-text">${contents[1]}</p>
                    <a href="/congratulation?name=${names[1]}&area=${areas[1]}&subject=${subject}" class="btn btn-primary">Записаться на курс</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${names[2]} ${areas[2]}</h5>
                    <p class="card-text">${contents[2]}</p>
                    <a href="/congratulation?name=${names[2]}&area=${areas[2]}&subject=${subject}" class="btn btn-primary">Записаться на курс</a>

                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="..." class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${names[3]} ${areas[3]}</h5>
                    <p class="card-text">${contents[3]}</p>
                    <a href="/congratulation?name=${names[3]}&area=${areas[3]}&subject=${subject}" class="btn btn-primary">Записаться на курс</a>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>