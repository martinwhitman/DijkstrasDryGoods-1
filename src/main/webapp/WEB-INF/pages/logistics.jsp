<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delivery Logistics</title>
</head>
<body>
	<c:forEach items="${all}" var="item">
		<table>
			<tr>
				<td>Tracking Number</td>
				<td>${item.trackingNumber}</td>
			</tr>
			<tr>
				<td>Delivery Order</td>
				<td>${item.deliveryOrder}</td>
			</tr>
			<tr>
				<td>Scheduled Delivery</td>
				<td>${item.scheduledDelivery}</td>
			</tr>
		</table>
		<br />
		<hr style="text-align: left; margin-left: 0; width: 25%">
		<br />
	</c:forEach>
<a href = "serviceSide.mvc">Return to main.</a><br />
</body>
</html>