package spring.DDG;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class OrderTracking {
	String trackingNumber;
	int deliveryOrder;
	String scheduledDelivery;
	

	public OrderTracking() {
	}
	
	public String getScheduledDelivery() {
		return scheduledDelivery;
	}
	public void setScheduledDelivery() {
		this.scheduledDelivery = Integer.toString(this.getDeliveryOrder()+7);
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public int getDeliveryOrder() {
		return deliveryOrder;
	}
	public void setDeliveryOrder() {
		//stand in for json parsing text which i am revising
		String s = this.getTrackingNumber();
		JSONParser parser = new JSONParser();
			
			try {
				JSONObject a = (JSONObject)parser.parse(new FileReader("C:\\Users\\marti\\eclipse-workspace\\DijkstrasDryGoods\\src\\main\\webapp\\manifest.json"));
				int dO = ((Long)a.get(s)).intValue();
				this.deliveryOrder=dO;
				
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
			
			
			
			
		
		
		
	}
	
	
}

