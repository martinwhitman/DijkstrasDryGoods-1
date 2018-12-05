<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
   <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Tracking</title>
</head>
<body>
<h1>Track My Order</h1>
<mvc:form modelAttribute="trackingNumber" action="trackResult.mvc" id="visible">
      <table>
          <tr>
              <mvc:label path="trackingNumber">Tracking Number:</mvc:label>
              <td><mvc:input path="trackingNumber" /></td>
          </tr>
       
          <tr>
              <td colspan="2">
                  <input type="submit" value="Submit" />
              </td>
          </tr>
      </table>
  </mvc:form>
</body>
</html>