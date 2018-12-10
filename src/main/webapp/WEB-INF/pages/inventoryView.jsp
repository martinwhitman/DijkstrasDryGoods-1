<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory</title>
</head>
<body>
	<c:forEach items="${all}" var="item">
		<table>
			<tr>
				<td>Item ID</td>
				<td>${item.id}</td>
			</tr>
			<tr>
				<td>Product</td>
				<td>${item.name}</td>
			</tr>
			<tr>
				<td>Price</td>
				<td>${item.price}</td>
			</tr>
			<tr>
				<td>Available</td>
				<td>${item.available}</td>
			</tr>
			<tr> 
				<td><input type="submit" id="editInventory.mvc" value="Edit" class="button button1"/></td>
				<td><a href = "editInventory.mvc">Edit inventory figures.</a></td>
			</tr>
		</table>
		<br />
		<hr style="text-align: left; margin-left: 0; width: 25%">
		<br />
	</c:forEach>
<a href = "editInventory.mvc">Edit inventory figures.</a><br />
<a href = "serviceSide.mvc">Return to main.</a><br />
</body>
</html>