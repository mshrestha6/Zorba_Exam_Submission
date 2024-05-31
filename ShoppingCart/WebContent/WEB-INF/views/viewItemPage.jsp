<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dhund
  Date: 5/31/2024
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Items</title>
</head>
<body>
<h1>Items Listed</h1>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  var="p" items="${itemInfo}">
        <tr>
            <td><c:out value="${p.itemName}"/></td>
            <td><c:out value="${p.itemQuantity}"/></td>
            <td><c:out value="${p.itemPrice}"/></td>
            <td><c:out value="${p.itemType}"/> </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
