<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Orders</title>
</head>
<body>
	<c:forEach items="${all}" var="item">
		<table>
			<tr>
				<td>Order Number</td>
				<td>${item.orderNumber}</td>
			</tr>
			<tr>
				<td>Motherboard(s)</td>
				<td>${item.mb}</td>
			</tr>
			<tr>
				<td>Processor(s)</td>
				<td>${item.processor}</td>
			</tr>
			<tr>
				<td>Solid State Drive(s)</td>
				<td>${item.ssd}</td>
			</tr>
			<tr>
				<td>Blue Ray Burner(s)</td>
				<td>${item.BRB}</td>
			</tr>
			<tr>
				<td>CPU Air Cooler(s)</td>
				<td>${item.cac}</td>
			</tr>
			<tr>
				<td>SDRAM DDR(4)</td>
				<td>${item.sdram}</td>
			</tr>
			<tr>
				<td>Gaming Video Card(s)</td>
				<td>${item.gvc}</td>
			</tr>
			<tr>
				<td>650W Power Supply(s)</td>
				<td>${item.ps}</td>
			</tr>
			<tr>
				<td>Steel Tower(s)</td>
				<td>${item.st}</td>
			</tr>
			<tr>
				<td>Hard Drive(s)</td>
				<td>${item.hd}</td>
			</tr>
			<tr>
				<td>Barebone System(s)</td>
				<td>${item.bbs}</td>
			</tr>
			<tr>
				<td>HDMI Cable(s)</td>
				<td>${item.hc}</td>
			</tr>
			<tr>
				<td>Shipping Type</td>
				<td>${item.shipType}</td>
			</tr>
			<tr>
				<td>Street Address</td>
				<td>${item.street}</td>
			</tr>
			<tr>
				<td>City</td>
				<td>${item.city}</td>
			</tr>
			<tr>
				<td>State</td>
				<td>${item.state}</td>
			</tr>
			<tr>
				<td>Zip</td>
				<td>${item.zip}</td>
			</tr>

		</table>
		<br />
		<hr style="text-align: left; margin-left: 0; width: 25%">
		<br />
	</c:forEach>
	
</body>
</html>