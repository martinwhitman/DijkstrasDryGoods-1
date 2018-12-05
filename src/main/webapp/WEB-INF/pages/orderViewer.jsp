<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View By Customer Order Number</title>
<script>

</script>
</head>
<body>
<h2>View by Order Number</h2>

<mvc:label path="orderNumber">Customer Order Number:</mvc:label>
<mvc:input path="orderNumber" id="ordernumber"/>
<input type="submit" value="Submit" />
</body>
</html>