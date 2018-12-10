<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Information</title>
</head>
<body> <h2>Order Information</h2>
    <table>
    	<tr>
            <td>Customer Order ID:</td>
            <td>${o.orderNumber}</td>
        </tr>
        <tr>
            <td>Motherboard(s):</td>
            <td>${o.mb}</td>
        </tr>
        <tr>
            <td>Processor(s):</td>
            <td>${o.processor}</td>
        </tr>
        <tr>
            <td>Solid State Drive(s):</td>
            <td>${o.ssd}</td>
        </tr>

        <tr>
            <td>Blue Ray Burner(s):</td>
            <td>${o.BRB}</td>
        </tr>
    	<tr>
            <td>CPU Air Cooler(s):</td>
            <td>${o.cac}</td>
        </tr>
        <tr>
            <td>SDRAM DDR4(s):</td>
            <td>${o.sdram}</td>
        </tr>
        <tr>
            <td>Gaming Video Card(s):</td>
            <td>${o.gvc}</td>
        </tr>
        <tr>
            <td>650W Power Supply(s):</td>
            <td>${o.ps}</td>
        </tr>

        <tr>
            <td>Steel Tower(s):</td>
            <td>${o.st}</td>
        </tr>
        <tr>
            <td>Hard Drive(s):</td>
            <td>${o.hd}</td>
        </tr>
        <tr>
            <td>Barebone System(s):</td>
            <td>${o.bbs}</td>
        </tr>

        <tr>
            <td>HDMI Cable(s):</td>
            <td>${o.hc}</td>
        </tr>
        </table>
<h2>Address and Shipping Information</h2>
    <table>
        <tr>
            <td>Shipping Type:</td>
            <td>${o.shipType}</td>
        </tr>
        <tr>
            <td>Street Address:</td>
            <td>${o.street}</td>
        </tr>
        <tr>
            <td>City:</td>
            <td>${o.city}</td>
        </tr>
        <tr>
            <td>State:</td>
            <td>${o.state}</td>
        </tr>
        <tr>
            <td>Zip Code:</td>
            <td>${o.zip}</td>
        </tr>
        </table>
<a href = "serviceSide.mvc">Return to main.</a><br />
</body>
</html>