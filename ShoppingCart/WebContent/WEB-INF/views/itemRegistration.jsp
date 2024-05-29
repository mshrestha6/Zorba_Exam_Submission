<%--
  Created by IntelliJ IDEA.
  User: dhund
  Date: 5/27/2024
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item Registration</title>
</head>
<body>
<form action="addItem" method="POST">
    <div>
        <label for="itemName">Item Name</label>
        <input id="itemName" name="itemName" type="text"/>
    </div>
    <div>
        <label for="itemType" >Item Type</label>
        <input id="itemType" name="itemType" type="text"/>
    </div>
    <div>
        <label for="itemQuantity" >Quantity</label>
        <input id="itemQuantity" name="itemQuantity" type="text"/>
    </div>
    <div>
        <label for="itemPrice" >Price</label>
        <input id="itemPrice" name="itemPrice" type="text"/>
    </div>

        <input type="Submit" value="Submit" />

</form>




</body>
</html>
