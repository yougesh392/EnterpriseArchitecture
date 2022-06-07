<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Books currently in the shop</title>
</head>

<body>
<h1>Books currently in the shop</h1>
<table>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.make}</td>
            <td>${book.model}</td>
            <td>${book.year}</td>
            <td>${book.color}</td>
            <td><a href="books/${book.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>

<a href="books/add"> Add a Book</a>
</body>

</html>