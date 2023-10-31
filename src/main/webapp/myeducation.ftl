<!DOCTYPE html>
<html>
<head>
    <title>Buttons Example</title>
    <link rel="stylesheet" type="text/css" href="myeducation.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script>
        $(document).on("click", "#ajax-button-schedule", function () {
            $("#ajax-response").text("Расписания еще нет, т.к. вы не учитесь");
        });
    </script>
    <script>
        $(document).on("click", "#ajax-button-home-tasks", function () {
            $("#ajax-response").text("Домашнего задания еще нет, т.к. вы не учитесь");
        });
    </script>
    <script>
        $(document).on("click", "#ajax-button-statistics", function () {
            $("#ajax-response").text("Статистики еще нет, т.к. вы не учитесь");
        });
    </script>
</head>
<body>
<div class="buttons-container">
    <button class="schedule" id="ajax-button-schedule">Расписание</button>
    <button class="home-tasks" id="ajax-button-home-tasks">Домашние задания</button>
    <button class="statistics" id="ajax-button-statistics">Статистика</button>
</div>
<div id="ajax-response">

</div>
</body>
</html>