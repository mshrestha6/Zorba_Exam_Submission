<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dhund
  Date: 5/31/2024
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vendor List</title>
</head>
<body>
<h2>List of Vendors</h2>
<table border="1">
    <thead>
    <th>Name</th>
    <th>Email</th>
    <th>Mobile</th>
    <th>Address</th>
    <th>Username</th>
    <th>Password</th>
    <th>Registration</th>
    </thead>
    <tbody>
    <c:forEach var="v" items="${vendors}">
    <tr>
        <td><c:out value="${vendor.vendorName}"/> </td>
        <td><c:out value="${vendor.vendorEmail}"/> </td>
        <td><c:out value="${vendor.vendorMobile}"/> </td>
        <td><c:out value="${vendor.vendorAddress}"/> </td>
        <td><c:out value="${vendor.vendorUserName}"/> </td>
        <td><c:out value="${vendor.vendorPassword}"/> </td>
        <td><c:out value="${vendor.vendorRegistration}" /></td>

    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
