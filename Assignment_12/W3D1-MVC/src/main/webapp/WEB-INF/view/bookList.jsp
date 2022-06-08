<%--
  Created by IntelliJ IDEA.
  User: jair
  Date: 6/6/22
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Books</h1>
<table>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.ISBN}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td><a href="books/${book.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>

<a href="books/add"> Add a Books</a>

</body>
</html>
