<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration page</title>
</head>
<body>

<form action="registration" method="post">
    Full name:
    <input type="text" name="name"/>
    <br>
    <br>
    E-mail/login:
    <input type="text" name="login"/>
    <br>
    <br>
    Date of birth:
    <input type="date" name="date"/>
    <br>
    <br>
    Password:
    <input type="password" name="password"/>
    <br>
    <br>
    Gender:
    M:<input type="radio" name="gender" checked value="M">
    W:<input type="radio" name="gender" checked value="W">
    <br>
    доделать табуляцию у гендера
    <br>
    Position:
    <br>
    &emsp;&emsp;Pupil:<input type="radio" name="position" checked value="Pupil">
    <br>
    &emsp;&emsp;Student:<input type="radio" name="position" checked value="Student">
    <br>
    &emsp;&emsp;Tutor:<input type="radio" name="position" checked value="Tutor">
    <br>
    &emsp;&emsp;Teacher:<input type="radio" name="position" checked value="Teacher">
    <br>
    <br>
    <input type="submit" value="Log in">
</form>

</body>
</html>