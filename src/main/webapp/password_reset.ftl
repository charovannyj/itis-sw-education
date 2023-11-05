<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">

<head>
    <link rel="stylesheet" type="text/css" href="profile.css">
    <meta charset="UTF-8">
    <title>Password recovery page</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#add-fields-btn').click(function() {
                $.ajax({
                    url: '/passwordReset', // URL-адрес, по которому будет выполняться запрос на сервер
                    method: 'GET', // HTTP-метод запроса
                    success: function(data) { // Обработчик успешного выполнения запроса
                        $('#new-fields').append(data); // Добавляем полученный HTML-код на страницу
                        $('#new-fields').show(); // Показываем новые поля ввода
                    }
                });
            });
        });
    </script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>



<form action="passwordReset" method="post">
    Логин:
    <input type="text" name="login"/>
    <br>

</form>

<button id="add-fields-btn" onclick="this.disabled=true">Добавить поля ввода</button>


<div id="new-fields" style="display: none;">
    <#--Question:
        ${question}
        <br>-->

    Answer:
    <input type="text" name="answer">
    <br>
    <input type="submit" value="Восстановить" id="enter">
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>