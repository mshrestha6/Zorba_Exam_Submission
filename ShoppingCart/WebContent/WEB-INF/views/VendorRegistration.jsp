<%--
  Created by IntelliJ IDEA.
  User: dhund
  Date: 5/28/2024
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vendor Registration Page</title>
</head>
<body>
<h1><i>Registration Page</i></h1>
<form action="registerVendor" method="post">
    <div>
        <label for="vendorName">Name: </label>
        <input type="text" name="vendorName" id="vendorName"/>
    </div>
    <div>
        <label for="vendorEmail">Email: </label>
        <input type="vendorEmail" name="vendorEmail" id="vendorEmail"/>
    </div>
    <div>
        <label for="vendorMobile">Mobile Number:</label>
        <input type="number" name="vendorMobile" id="vendorMobile"/>
    </div>
    <div>
        <label for="vendorAddress">Address:</label>
        <input type="text" name="vendorAddress" id="vendorAddress"/>
    </div>
    <div>
        <label for="vendorUserName">UserName:</label>
        <input type="text" name="vendorUserName" id="vendorAddress"/>
    </div>
    <div>
        <label for="vendorPassword">Password:</label>
        <input type="text" name="vendorPassword" id="vendorPassword"/>
    </div>
    <div>
        <label for="vendorRegistration">Registration:</label>
        <input type="text" name="vendorRegistration" id="vendorRegistration"/>
    </div>
    <div>
        <input type="submit" value="submit"/>
    </div>
</form>

</body>
</html>
