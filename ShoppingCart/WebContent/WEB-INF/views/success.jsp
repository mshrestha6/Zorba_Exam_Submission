<%--
  Created by IntelliJ IDEA.
  User: dhund
  Date: 5/31/2024
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>Data Saved Successfully..YAY!!!!</h1>
<h3>${response}</h3>
<a href="localhost:8080/ShoppingCart_war/item/fetchItem">Items list</a>
<a href="localhost:8080/ShoppingCart_war/customer/fetchCustomer">Customer List</a>
<a href="localhost:8080/ShoppingCart_war/vendor/fetchVendor">Vendor List</a>

</body>
</html>
