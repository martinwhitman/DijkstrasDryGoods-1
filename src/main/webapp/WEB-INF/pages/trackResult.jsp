<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
   <%@ page isELIgnored="false" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tracking Result</title>
</head>
<body>
<h1>Tracking Result</h1>
<table>

<tr><td>Tracking Number</td><td>${t.trackingNumber}</td></tr>
<tr><td>Delivery Order</td><td>${t.deliveryOrder}</td></tr>
<tr><td>Delivery Time</td><td>${t.scheduledDelivery}</td></tr>
</table>
</body>
</html>