<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="/login" method="post">
    <p>
        <label>Email:<br>
            <input type="email" name="email" required>
        </label>
    </p>
    <p>
        <label>Password:<br>
            <input type="password" name="password" required>
        </label>
    </p>
    <p>
        <label>Remember Email:
            <input type="checkbox" name="rememberEmail">
        </label>
    </p>
    <input type="submit" value="Login">

    <div>

    </div>
</form>
</body>
</html>
