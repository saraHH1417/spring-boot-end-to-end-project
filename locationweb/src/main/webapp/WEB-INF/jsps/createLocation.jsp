<%@ page language="java"
         contentType="text/html; ISO-8859-1"
         pageEncoding="utf-8" %>
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
    ${msg}
    <form action="saveLocation" method="post">
        <pre>
            Code: <input type="text" name="code">
            Name: <input type="text" name="name">
            Type: Urban: <input  type="radio" name="type" value="URBAN">
                Rural: <input type="radio" name="type" value="RURAL">
            <input type="submit" value="save">
        </pre>
    </form>
</body>
<a href="displayLocations">View All</a>
</html>