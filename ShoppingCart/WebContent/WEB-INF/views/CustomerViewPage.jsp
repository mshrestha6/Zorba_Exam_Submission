<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dhund
  Date: 5/31/2024
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Data Listed Page</title>
</head>
<body>
<h1>Customer List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Address</th>
        <th>Username</th>
        <th>Password</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td><c:out value="${c.customerName}"/> </td>
            <td><c:out value="${c.customerEmail}"/> </td>
            <td><c:out value="${c.MobileNo}"/> </td>
            <td><c:out value="${c.customerAddress}"/> </td>
            <td><c:out value="${c.customerUserName}"/> </td>
            <td><c:out value="${c.customerPassword}"/> </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

</body>
</html>
