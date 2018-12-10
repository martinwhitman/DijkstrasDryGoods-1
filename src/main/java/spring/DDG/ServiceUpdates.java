package spring.DDG;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currentinventory")
public class ServiceUpdates {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*private int motherboard;
	private int processor;
	private int ssd;
	private int blueray;
	private int aircooler;
	private int sdram;
	private int gamingcard;
	private int powersupply;
	private int tower;
	private int harddrive;
	private int barebone;
	private int hdmi;*/
	private int id;
	private String name;
	private double price;
	private int available;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
	
	

	
	
	
	

	
}
