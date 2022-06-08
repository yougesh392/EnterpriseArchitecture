<%--
  Created by IntelliJ IDEA.
  User: jair
  Date: 6/6/22
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${msg == 'Update'}">
<form action="../books/${book.id}" method="post">
    </c:if>
    <c:if test="${msg == 'Add'}">
    <form action="../books" method="post">
        </c:if>
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" value="${book.title}" /> </td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><input type="text" name="ISBN" value="${book.ISBN}" /> </td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><input type="text" name="author" value="${book.author}" /> </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value="${book.price}" /> </td>
            </tr>
        </table>
        <input type="submit" value="${msg}"/>
    </form>
    <c:if test="${msg == 'Update'}">
    <form action="delete?id=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form>
    </c:if>

</body>
</html>
