<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Customer</title>
</head>
<body>

    <h2>Update Customer Information</h2>

    <form action="${pageContext.request.contextPath}/api/customers/1" method="POST">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" value="Old Name" required><br><br>
        
        <label for="address">Address:</label><br>
        <input type="text" id="address" name="address" value="Old Address" required><br><br>
        
        <input type="submit" value="Update Customer">
    </form>

</body>
</html>
