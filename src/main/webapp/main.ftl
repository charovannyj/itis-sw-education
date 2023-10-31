<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        #profileOptions {
            position: absolute;
            top: 120px;
            right: 0;
            background-color: white;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            padding: 10px;
        }

        #profileOptions a {
            display: block;
            margin-bottom: 10px;
        }
    </style>
    <style>
        .container {
            display: flex;
            flex-direction:row;
            height: 100vh;
            justify-content: space-around;
        }
        .forum {
            width: 600px;
            padding: 20px;
            background-color: #f2f2f2;
            border-radius: 10px;
        }
        .message-input {
            width: 100%;
            height: 100px;
            margin-top: 20px;
        }
        .send-button {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
    <title>Пример страницы</title>
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
<div id="output"></div>

<div class="education-photo">
    <img src="education.png" height="457">
</div>

<div class="education">
    <a href="/education"><button class="education-button">Моё обучение</button></a>
</div>

<form method="post" action="/main">
<textarea name="message" placeholder="Введите сообщение"></textarea>
<input type="submit"></form>

${forums}

<script>
function openProfileOptions() {
var options = document.getElementById("profileOptions");
if (options.style.display === "none") {
options.style.display = "block";
} else {
options.style.display = "none";
}
}
</script>
</body>
</html>