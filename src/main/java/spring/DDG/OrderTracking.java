package spring.DDG;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class OrderTracking {
	String trackingNumber;
	
	String scheduledDelivery;
	
	
	
	
	/**
	 * 
	 */
	public OrderTracking() {
	}
	/**
	 * @param trackingNumber
	 * @param deliveryOrder
	 */
	
	public String getScheduledDelivery() {
		return scheduledDelivery;
	}
	public void setScheduledDelivery() {
		String s = this.getTrackingNumber();
		JSONParser parser = new JSONParser();
			
			try {
				JSONObject a = (JSONObject)parser.parse(new FileReader("C:\\Users\\marti\\eclipse-workspace\\DijkstrasDryGoods\\mainfest.json"));
				int dS = ((Long)a.get(s)).intValue();
				this.scheduledDelivery=Integer.toString(dS);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(NullPointerException e) {
				this.scheduledDelivery="Not scheduled yet";
			}
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	//public int getDeliveryOrder() {
		//return deliveryOrder;
	//deprecated
	//}
	//public void setDeliveryOrder() {
		//deprecated
		
			
			
			
			
		
		
		
	}
	
	


