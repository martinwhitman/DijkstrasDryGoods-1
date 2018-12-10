<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Sales by Product</title>
</head>
<body>
<h2>View Sales by Product</h2>
<mvc:form modelAttribute="viewSalesByProd" action="salesResult.mvc" id="visible">
	    <p>
	        <label>
	        <span>Product Type:</span></label>
	        <br />
	        <input type="radio" name="productType" value="motherboard"> Motherboard<br>   
	        <input type="radio" name="productType" value="processor"> Processor<br> 
	        <input type="radio" name="productType" value="solid_state_drive"> Solid State Drive<br>   
	        <input type="radio" name="productType" value="blue_ray_burner"> Blue Ray Burner<br>   
	        <input type="radio" name="productType" value="cpu_air_cooler"> CPU Air Cooler<br> 
	        <input type="radio" name="productType" value="sdram_ddr4"> SDRAM DDR4<br> 
	        <input type="radio" name="productType" value="gaming_video_card"> Gaming Video Card<br>   
	        <input type="radio" name="productType" value="power_supply_650w"> 650W Power Supply<br> 
	        <input type="radio" name="productType" value="steel_tower"> Steel Tower<br>  
	        <input type="radio" name="productType" value="hard_drive"> Hard Drive<br>   
	        <input type="radio" name="productType" value="booksize_barebone_system"> Booksize Barebone System<br> 
	        <input type="radio" name="productType" value="hdmi_cable"> HDMI Cable<br> 
	    </p>
        <p> <input type="submit" id="submit" value="Submit" class="button button1"/>
        	</p> 
</mvc:form>
</body>
</html>