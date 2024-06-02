<%--
  Created by IntelliJ IDEA.
  User: dhund
  Date: 5/27/2024
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration</title>
    <marquee>Register First Comer</marquee>

</head>
<body>
<h2>Customer Registration Form</h2>
<form action="register" method="post">
    <div>
    <label for="customerName"> Name: </label>
        <input id="customerName" name="customerName" type="text"/>
    </div>
    <div>
        <label for="customerEmail">Email</label></div>
    <input id="customerEmail" name="customerEmail" type="text"/>
    <div>
        <label for="mobileNo">Mobile Number</label>
        <input id="mobileNo" name="mobileNo" type="text"/>
    </div>
    <div>
        <label for="customerAddress">Address: </label>
        <input id="customerAddress" name="customerAddress" type="text"/>
    </div>
    <div>
        <label for="customerUserName">UserName</label>
        <input id="customerUserName" name="customerUserName" type="text"/>
    </div>
    <div>
        <label for="customerPassword">Password</label>
        <input id="customerPassword" name="customerPassword" type="text"/>
    </div>
    <div>
        <input type="submit" value="Submit"/>
    </div>
</form>

</body>
</html>
