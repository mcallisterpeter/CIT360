<%--
  Created by IntelliJ IDEA.
  User: troytuckett
  Date: 2019-02-02
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="small.css">
</head>
<body>
    <h1>Welcome to the tip tracker</h1>
    <p>To track your tips we will need the order id, sale amount, and tip amount</p>
    <p>
        The order ID must be a whole number<br>
        The sale amount must be a number<br>
        The tip amount must be a number<br>
    </p>
    <a href="${pageContext.request.contextPath}/tip_tracker.html"><p>LET'S START TRACKING!!</p></a>
</body>
</html>