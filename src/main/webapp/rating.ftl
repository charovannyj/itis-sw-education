<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script>
        $('#person-select').on('change', function() {
            var personId = $(this).val();
            $.ajax({
                url: '/rating',
                type: 'GET',
                data: { personId: personId },
                success: function(data) {
                    $('#action-select').html(data);
                }
            });
        });
    </script>

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
<form>
    <div class="form-group">
        <label for="person-select">Выберите человека:</label>
        <select class="form-control" id="person-select">
            <option value="1">Женя</option>
            <option value="2">Саша</option>
        </select>
    </div>
    <div class="form-group">
        <label for="action-select">Выберите действие:</label>
        <select class="form-control" id="action-select"></select>
    </div>
</form>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>