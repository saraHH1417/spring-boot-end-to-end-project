<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!Doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h3>Locations:</h3>
    <table>
        <tr>
            <th>id</th>
            <th>code</th>
            <th>name</th>
            <th>type</th>
        </tr>
        <c:forEach items="${locations}" var="location">
            <tr>
                <td>${location.id}</td>
                <td>${location.code}</td>
                <td>${location.name}</td>
                <td>${location.type}</td>
                <td>
                    <a href="deleteLocation?id=${location.id}">Delete</a>
                </td>
                <td>
                    <a href="updateLocation?id=${location.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>