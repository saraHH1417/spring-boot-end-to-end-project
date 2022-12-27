<%@ page language="java"
         contentType="text/html; ISO-8859-1"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!Doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create Location</title>
</head>
<body>
<form action="editLocation" method="put">
        <pre>
            ID: <input type="text" name="id" value="${location.id}" readonly>
            Code: <input type="text" name="code" value="${location.code}">
            Name: <input type="text" name="name" value="${location.name}">
            Type: Urban: <input  type="radio" name="type" value="URBAN" ${location.type == "URBAN" ? "checked" : ''} >
                Rural: <input type="radio" name="type" value="RURAL" ${location.type == "RURAL" ? "checked" : ''}>
            <input type="submit" value="save">
        </pre>
</form>
</body>
</html>