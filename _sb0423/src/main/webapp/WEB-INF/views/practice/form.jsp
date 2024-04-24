<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Validation 연습 폼</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h2>Validation 연습 폼</h2>
<form:form modelAttribute="inputRequest"> <!--inputRequest 이름으로 값을 보낸다!-->
    <p>
        <lable>이름:<br>
    <form:input path="name" />
    <form:errors path="name" /> <!--에러가 있다면 내용이 출력된다. -->
        </lable>
    </p>
    <p>
        <lable>나이:<br>
            <form:input path="age" />
            <form:errors path="age" /> <!--에러가 있다면 내용이 출력된다. -->
        </lable>
    </p>
    <p>
        <lable>전화번호:<br>
            <form:input path="phone" />
            <form:errors path="phone" /> <!--에러가 있다면 내용이 출력된다. -->
        </lable>
    </p>
    <p>
        <lable>이메일:<br>
            <form:input path="email" />
            <form:errors path="email" /> <!--에러가 있다면 내용이 출력된다. -->
        </lable>
    </p>
    <p>
        <lable>주소:<br>
            <form:input path="addr" />
            <form:errors path="addr" /> <!--에러가 있다면 내용이 출력된다. -->
        </lable>
    </p>
    <input type="submit">
</form:form>
</body>
</html>