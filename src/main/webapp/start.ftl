<!DOCTYPE html>
<html>
<head>
    <title>Простой HTML файл</title>
    <script>
        function goToLogin() {
            window.location.href = "/login";
        }

        function goToRegistration() {
            window.location.href = "/registration";
        }
    </script>
</head>
<body>
<button onclick="goToLogin()">У меня есть аккаунт</button>
<button onclick="goToRegistration()">Я тут новенький</button>
</body>
</html>