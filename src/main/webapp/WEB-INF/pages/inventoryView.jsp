<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Inventory</title>
</head>
<body>
<h2>View Inventory Figures</h2>
<mvc:form modelAttribute="editInventory" action="updatedInventoryResult.mvc" id="visible">
	    <p>
	        <label>
	        <span>Motherboard:</span>
	        </label>
			<input id="mb"/>        
	    </p>
	    <p>
	        <label>
	        <span>Processor:</span>
	        </label>
			<input id="processor"/>        
	    </p>
	    <p>
	        <label>
	        <span>Solid State Drive:</span>
	        </label>
			<input id="ssd"/>        
	    </p>
	    <p>
	        <label>
	        <span>Blue Ray Burner:</span>
	        </label>
			<input id="BRB"/>        
	    </p>
	    <p>
	        <label>
	        <span>CPU Air Cooler:</span>
	        </label>
			<input id="cac"/>        
	    </p>
	    <p>
	        <label>
	        <span>SDRAM DDR4:</span>
	        </label>
			<input id="sdram"/>        
	    </p>
	    <p>
	        <label>
	        <span>Gaming Video Card:</span>
	        </label>
			<input id="gvc"/>        
	    </p>
	    <p>
	        <label>
	        <span>650W Power Supply:</span>
	        </label>
			<input id="ps"/>        
	    </p>
	    <p>
	        <label>
	        <span>Steel Tower:</span>
	        </label>
			<input id="st"/>        
	    </p>
	    <p>
	        <label>
	        <span>Hard Drive:</span>
	        </label>
			<input id="hd"/>        
	    </p>
	    <p>
	        <label>
	        <span>Barebone System:</span>
	        </label>
			<input id="bbs"/>        
	    </p>
	    <p>
	        <label>
	        <span>HDMI Cable:</span>
	        </label>
			<input id="hc"/>        
	    </p>
        <p> <input type="submit" id="submit" value="Submit" class="button button1"/>
        </p> 
        
</mvc:form>
<a href = "editInventory.mvc">Edit inventory figures.</a><br />
<a href = "serviceSide.mvc">Return to main.</a><br />
</body>
</html>