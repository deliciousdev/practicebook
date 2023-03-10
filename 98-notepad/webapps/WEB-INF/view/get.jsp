<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>home</title>
</head>
<body>
<div>${msg}</div>
<div>${model}</div>

<form action="/myuri" method="post">


    <div>
        <label>id <input type="text" name="id"></label>
    </div>
    <div>
        <label>password <input type="text" name="password"></label>
    </div>
    <input type="submit" name = "button" value="admin">
    <input type="submit" name = "button" value="normal">
    <input type="submit" name = "button" value="notuser">

</form>
</body>
</html>