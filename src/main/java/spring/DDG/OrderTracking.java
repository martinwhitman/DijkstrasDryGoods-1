package spring.DDG;




public class OrderTracking {
	String trackingNumber;
	int deliveryOrder;
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
		this.deliveryOrder = 2;
	}
	
	
}
