<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Inventory</title>
</head>
<body>
<h2>Edit Inventory Figures</h2>
<mvc:form modelAttribute="editInventory" action="viewCurrentInventory.mvc" id="visible">
	    <p>
	    	<input type="radio" name="name" value="1"> Motherboard<br> 
	        <label>
	        <span>New Inventory Figure:</span>
	        </label>
			<input id="new"/>        
	    </p>
	    <p>
	    	<input type="radio" name="name" value="2"> Processor<br>
	        <label>
	        <span>Processor:</span>
	        </label>
			<input id="new"/>        
	    </p>
	    <p>
	    	<input type="radio" name="name" value="3"> Motherboard<br>
	        <label>
	        <span>Solid State Drive:</span>
	        </label>
			<input id="3"/>        
	    </p>
	    <p>
	    	<input type="radio" name="name" value="4"> Motherboard<br>
	        <label>
	        <span>Blue Ray Burner:</span>
	        </label>
			<input id="4"/>        
	    </p>
	    <p>
	        <label>
	        <span>CPU Air Cooler:</span>
	        </label>
			<input id="5"/>        
	    </p>
	    <p>
	        <label>
	        <span>SDRAM DDR4:</span>
	        </label>
			<input id="6"/>        
	    </p>
	    <p>
	        <label>
	        <span>Gaming Video Card:</span>
	        </label>
			<input id="7"/>        
	    </p>
	    <p>
	        <label>
	        <span>650W Power Supply:</span>
	        </label>
			<input id="8"/>        
	    </p>
	    <p>
	        <label>
	        <span>Steel Tower:</span>
	        </label>
			<input id="9"/>        
	    </p>
	    <p>
	        <label>
	        <span>Hard Drive:</span>
	        </label>
			<input id="10"/>        
	    </p>
	    <p>
	        <label>
	        <span>Barebone System:</span>
	        </label>
			<input id="11"/>        
	    </p>
	    <p>
	        <label>
	        <span>HDMI Cable:</span>
	        </label>
			<input id="12"/>        
	    </p>
        <p> <input type="submit" id="submit" value="Submit" class="button button1"/>
        </p> 
        
</mvc:form>
<a href = "serviceSide.mvc">Return to main.</a><br />
</body>
</html>