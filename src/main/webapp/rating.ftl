<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <#--<script>
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
        <form action="rating" method="post">
            <div class="form-group">
                <label for="person-select">Выберите предмет:</label>
                <select name="subject" class="form-control" id="subject-select">
                    <#list subjects as subject>
                        <option value=${subject}>${subject}</option>
                    </#list>

                </select>
            </div>
            <div class="form-group">
                <label for="action-select">Выберите курс:</label>
                <select name="area" class="form-control" id="area-select">
                    <#list areas as area>
                        <option value=${area}>${area}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="action-select">Выберите преподавателя:</label>
                <select name="name" class="form-control" id="name-select">
                    <#list names as name>
                        <option value=${name}>${name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="action-select">Укажите оценку:</label>
                <select name="grade" class="form-control" id="name-select">
                    <option value="1 балл">1</option>
                    <option value="2 балла">2</option>
                    <option value="3 балла">3</option>
                    <option value="4 балла">4</option>
                    <option value="5 баллов">5</option>
                </select>
            </div>
            <textarea class="textarea" name="message" placeholder="Напишите свой отзыв" charset="UTF-8"></textarea>

            <input type="submit">
        </form>
        <#list ratings as rating>
            <div class="card">
                <div class="card-body">
                    <h6 class="card-title">${rating.login_user} оценил учителя ${rating.teacher} по предмету ${rating.subject} ${rating.area} на ${rating.grade}</h6>
                    <p class="card-text">${rating.content}</p>
                </div>
            </div>
        </#list>
    </div>
</div>




<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>