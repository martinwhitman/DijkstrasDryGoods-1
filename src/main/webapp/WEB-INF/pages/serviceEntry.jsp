<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Service Interface</title>
</head>
<body>
<h2>User Selections</h2>
Please make a selection from the following choices:
<br />

<font face="Times New Roman" size="4">
<a href = "orderViewForm.mvc">View a customer order by the order number.</a><br />
<a href = "editInventory.mvc">Edit inventory figures.</a><br />
<a href = "viewCurrentInventory.mvc">View current inventory.</a><br />
<a href = "viewPendingDeliveries.mvc">View pending/in transit shipments.</a><br />
<a href = "viewAll.mvc">View all orders.</a>
</font>

<h2>Manager Options</h2>
Please make a selection from the following choices:
<br />
<b>
<font face="Times New Roman" size="4">
<a href = "viewSalesByProd.mvc">View sales by product.</a><br />
<a href = "viewOverallSales.mvc">View overall sales figures.</a><br />
<a href = "calculateProfitLoss.mvc">Calculate profit/loss by product.</a><br />
<a href = "calculateLogistics.mvc">Calculate efficient delivery logistics.</a>
</font>
</b>
</body>
</html>