
package spring.DDG;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderItems")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderNumber;
	private int mb;
	private int processor;
	private int ssd;
	private int BRB;
	private int cac;
	private int sdram;
	private int gvc;
	private int ps;
	private int st;
	private int hd;
	private int bbs;
	private int hc;
	private String street;
	private String city;
	private String zip;
	private Shipping shipType;
	private String state;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Shipping getShipType() {
		return shipType;
	}
	public void setShipType(Shipping shipType) {
		this.shipType = shipType;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getMb() {
		return mb;
	}
	public void setMb(int mb) {
		this.mb = mb;
	}
	public int getProcessor() {
		return processor;
	}
	public void setProcessor(int processor) {
		this.processor = processor;
	}
	public int getSsd() {
		return ssd;
	}
	public void setSsd(int ssd) {
		this.ssd = ssd;
	}
	public int getBRB() {
		return BRB;
	}
	public void setBRB(int bRB) {
		BRB = bRB;
	}
	public int getCac() {
		return cac;
	}
	public void setCac(int cac) {
		this.cac = cac;
	}
	public int getSdram() {
		return sdram;
	}
	public void setSdram(int sdram) {
		this.sdram = sdram;
	}
	public int getGvc() {
		return gvc;
	}
	public void setGvc(int gvc) {
		this.gvc = gvc;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getSt() {
		return st;
	}
	public void setSt(int st) {
		this.st = st;
	}
	public int getHd() {
		return hd;
	}
	public void setHd(int hd) {
		this.hd = hd;
	}
	public int getBbs() {
		return bbs;
	}
	public void setBbs(int bbs) {
		this.bbs = bbs;
	}
	public int getHc() {
		return hc;
	}
	public void setHc(int hc) {
		this.hc = hc;
	}
	
	//adding for use in view full inventory method and view order(s) methods
	public String returnOrderDetails() {
		return ("Order Number: " + orderNumber + "Motherboards: " + mb + "Processors: " + processor + "Solid State Drives: " + ssd + "Bluray Burners: " + BRB + "CPU Air Coolers: " + cac + "SDRAM DDR4: " + sdram + "Gaming Video Cards: " + gvc + "Power Supplies: " + ps + "Steel Towers: " + st + "Hard Drives: " + hd + "Booksize Barebones Systems: " + bbs + "HDMI Cables: " + hc + "Street: " + street + "City: " + city);
		//missing shipping method choice?
	}
	
	
}
