package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import model.DijkstraPQ.Edge;
import model.DijkstraPQ.Graph;
import model.DijkstraPQ.Order;
import model.DijkstraPQ.OrderLocation;
import model.DijkstraPQ.OrderNumber;
//update
public class Deliveries extends Graph{
    LocalDate shipdate;
    FileWriter file;
    
    JSONObject JSONPersist;
	Orders orders;
	Times times;
	//Vector<DelTime> times;

	
	public class Orders implements Iterable <Order>{

		Vector<Order> orderList;
		
		Orders(){
			orderList = new Vector<Order>(); 
						
		}
		/* Adds Iterable for each use*/
	    public Iterator<Order> iterator() {
	        return orderList.iterator();
	    }
		public void addOrder(Order incomingOrder) {
			orderList.addElement(incomingOrder);
			System.out.println("Order Added.");
		}
    	public void addOrder(String num,
    			Integer source,
    			Integer destination,
    			Integer weight
    			){	
    		Order newOrder =null;
    		OrderNumber newNum = new OrderNumber( num);
    		OrderLocation newLoc = new OrderLocation(source,destination,weight);
    		newOrder = new Order (newNum, newLoc);
			orderList.addElement(newOrder);
			System.out.println("Order Added.");
    		
    	}

	
	}
	
	public class DelTime{
		Integer hour;
		String TrackingNumber;
		
		DelTime(){
			setHour(700);
			setTrackingNumber("Empty");
			
		}
		DelTime(Integer hourOf, String trackNum){
			setHour(hourOf);
			setTrackingNumber(trackNum);
		}

		public Integer getHour() {
			return hour;
		}

		public void setHour(Integer hour) {
			this.hour = hour;
		}

		public String getTrackingNumber() {
			return TrackingNumber;
		}

		public void setTrackingNumber(String trackingNumber) {
			TrackingNumber = trackingNumber;
		}
		@Override
		public String toString() {
			return "DelTime [hour=" + hour + ", TrackingNumber=" + TrackingNumber + "]";
		}
		
		
		
	}
	public class Times{
		Vector <DelTime> timeList;
		
		Times(){
			timeList = new Vector<DelTime>();
			
		}
    	public Vector<DelTime> getTimeList() {
			return timeList;
		}


		public void setTimeList(Vector<DelTime> timeList) {
			this.timeList = timeList;
		}

		public void addTime(Integer minutes,String num){	
    		DelTime newTime = null;
    	
    		
    		newTime = new DelTime(minutes,num);
    		this.timeList.addElement(newTime);

			System.out.println("Time Added.");
    		
    	}
		
		/* Uses minToHour() at launch
		 * 
		 * */
/*
		public void addTime(Integer minutes,String num){	
    		DelTime newTime = null;
    	
    		
    		newTime = new DelTime(minToHour(minutes),num);
    		this.timeList.addElement(newTime);

			System.out.println("Time Added.");
    		
    	} */
    	
	}

	
	
	
	//Vertices here are known as Locations
	
	Deliveries(int locations) {
		//Locations determines how many stops there are to make
		super(locations);
		//Int represents order placement, ergo priority
		 this.orders= new Orders();
		 this.JSONPersist = new JSONObject();
		 this.times= new Times();
		/*
		 *     static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }*/
		//private Map<Integer,Edge> delivery;


		
		
		// TODO Auto-generated constructor stub
	}/*
	*/
	Deliveries(int locations, Orders incomingOrders){
		super(locations);
		 this.orders= new Orders();
		 this.JSONPersist = new JSONObject();
		 this.times= new Times();
		
		for(Order o : incomingOrders) {
		this.addOrder(
				o.getoNum().getOrderNumber(), //Gets Order Number
				o.getoLoc().getOrderLocation().getSource(), // gets order details
				o.getoLoc().getOrderLocation().getDestination(),
				o.getoLoc().getOrderLocation().getWeight());
		}
		
	}


	
		
	/*
	public static void sortSequence(Vector<Order> sequenceIn){
		Collections.sort(sequenceIn, sequenceIn.);
		
	}*/
	
	/*	Current purpose is debug only
	 * JSON Retrieval
	 * JSON Mapping FROM JSON file
	 * JSON Mapping codes parts 1 and 2 from user:
	 * Sermintt
	 * https://stackoverflow.com/users/4281350/sermintt
	 * https://stackoverflow.com/questions/32823746/java-code-to-convert-json-into-text-in-key-value-pair
	 * Also uses JSON dependencies added to POM.xml
	 * 
	 * Mapping Code Part 1*/
	public static Map<String,Integer> parseJSONObjectToMap(JSONObject jsonObject) throws JSONException{
	    Map<String, Integer> mapData = new HashMap<String, Integer>();
	    Iterator<String> keysItr = jsonObject.keys();
	        while(keysItr.hasNext()) {
	            String key = keysItr.next();
	            Object value = jsonObject.get(key);

	            if(value instanceof JSONArray) {
	                value = parseJSONArrayToList((JSONArray) value);
	            }else if(value instanceof JSONObject) {
	                value = parseJSONObjectToMap((JSONObject) value);
	            }
	            mapData.put(key, (Integer) value);
	        }
	    return mapData;
	}
	/* Mapping Code Part 2*/
	
	public static List<Object> parseJSONArrayToList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = parseJSONArrayToList((JSONArray) value);
	        }else if(value instanceof JSONObject) {
	            value = parseJSONObjectToMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
	/* End of JSON retrieval methods
	 * Current purpose is debug only*/
	
	/* Time class creation method, debug only at this point
	 * */
	public DelTime makeTime(Integer minutes, String number) {
		
		DelTime maybeBadIdea = new DelTime(minutes,number);
		return maybeBadIdea;
	}
	
	/*
	 * Set times vector for time table generation from orderSequence
	 * 
	 * 
	 * */
	
	
	

	/*	Random Time table generator
	 * 	Normalizes order to hours based on 
	 * 	Data from random sources on the internet.
	 * 	surprisingly, no hard average available.
	 * 	Using average from Stephen Meyer's article"
	 * 	https://www.citylab.com/life/2018/07/man-of-letters/565979/
	 * 	Shifts: 8-10 hrs/day, 12 during holidays
	 * 	50 to 60 packages/day, averaging to 55.
	 * 	Math:
	 * 	55/8 hours, 6.875, so 7 packages per hour
	 * 	60/6.875 ~ 8.73
	 * 	Let's say 9 minutes per package
	 * 	This is *postal* routes though,
	 * 	I think we should add some "travel time"
	 * 	due to variability of shipping routes. 
	 * 	five additional minutes per parcel sounds reasonable;
	 * 	We can ball park and say about 14 minutes per package
	 * 
	 * */
	public Integer minToHour(Integer minutes) {
		/*
		 * reference:
		 * https://stackoverflow.com/questions/47752102/force-integer-division-on-a-double
		 * 
		 * */
		final int DISPATCH = 700;
		final int HOUR = 60;
		final int HUNDRED = 100;
		Integer hours = null;
		Integer mins= null;
		Integer hundredHours =null;
		/*
		 * x = (long)(x / y); will get integer part of the operation
		 * 220/60 = 3 //integer division, regular division would give 3.666-
		 * 
		 * */
		System.out.println(" minToHour, minutes in: "+ minutes);
		hours = ((Integer)(minutes/HOUR));
		hours*= HUNDRED;
		hours+= DISPATCH;
		System.out.println(" minToHour, hours: "+ hours);
		/* Should return minute portion that is not hour
		 * 220%60 = 40
		 * */
		mins = (minutes%HOUR);
		System.out.println(" minToHour, mins: "+ mins);
		hundredHours = hours+mins;	
		System.out.println(" minToHour, hundred hours: "+ hundredHours);
		return hundredHours;
	}
	public void timeTable() {
		final Integer AVERAGE = 14;
		Vector<DelTime> holding = null;
		DelTime holder=null;
		Integer timeTemp = null;
		/**
		orderSequence.forEach((o)->this.times.addTime(s
				minToHour(o.getDistance()*AVERAGE),o.getoNum().getOrderNumber()));
		**/
		for(int i =0;i<this.orderSequence.size();i++) {
			timeTemp = (minToHour((orderSequence.get(i).getDistance()*AVERAGE)));
			System.out.println("Time temp: "+timeTemp);
			System.out.println("Order: "+i+" "+ orderSequence.get(i).getDistance());
			System.out.println("Order: "+i+" "+ orderSequence.get(i).getDistance());
			System.out.println("Order minutes: "+i+" "+ (orderSequence.get(i).getDistance()*AVERAGE));
			this.times.addTime(timeTemp,
					orderSequence.get(i).getoNum().getOrderNumber());
			//System.out.println("Time Created ");
		}
	}	
		
	/* Create JSON Delivery Manifest
	 * 
	 * */
	/*public void makeManifest(Orders orderVector) {
        LocalDate shipdate = LocalDate.now();
        //FileWriter file=null;
        
        try{this.file = new FileWriter("Deliveries "+shipdate+".txt");
        		
        	this.JSONPersist.put(" "+shipdate+" Route",0);
        }catch(IOException e) {
        	e.printStackTrace();
        }
		for(Order o: orderVector) {
			this.JSONPersist.put(o.oNum.getOrderNumber(), o.getDistance());
		try{
			this.file.write(this.JSONPersist.toString());
			
			System.out.println("------------------------------------------");

			System.out.println("\nJSON Object: " + this.JSONPersist.toString());
		} catch(IOException e){
			e.printStackTrace();
		}finally {
			/*
			try{file.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
			try{file.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			if (file!=null) {
				try {
					file.flush();
					file.close();
				}catch (IOException e) {
					//report exception
				}
			}
		}
		}
        }*/
	//End make manifest
	// makeManifest()
	public void makeManifest() {
        LocalDate shipdate = LocalDate.now();
        //Establishes time table
        this.timeTable();
        //FileWriter file=null;
        
        
        
        /* Code for writing to JSON file begins here*/
        /* Current JSON file idea:
         * All delivery files are of the format:
         * Deliveries YYYY-MM-DD.txt //ex: "Deliveries 2018-11-30.txt"
         * Using shipdate to get date for delivery manifest name.
         * 
         * */
        
        
        try{file = new FileWriter("Deliveries "+shipdate+".txt");
        		
        	JSONPersist.put(" "+shipdate+" Route",0);
        	//vector.forEach((n) -> print(n))
        	//this.orders.forEach((o)->System.out.println(o.getoNum().getOrderNumber().toString()));
        	orderSequence.forEach((o)->JSONPersist.put(" "+o.getoNum().getOrderNumber()+" ", o.getDistance()));
			//JSONPersist.put(this.orderSequence. //.getoNum().getOrderNumber(), o.getDistance());
        	//for(int i=0; i<orders.orderList.size();i++) {
			//	JSONPersist.put()
			//}
        	file.write(JSONPersist.toString());
			file.flush();
			file.close();
        	//for(Order o: this.orders) {
    		//	this.JSONPersist.put(o.oNum.getOrderNumber(), o.getDistance());
    		//}
			System.out.println("------------------------------------------");

			System.out.println("\nJSON Object: " + JSONPersist.toString());
			System.out.println(" Print time table: ");
			this.times.timeList.forEach((t)->System.out.println(t.toString()));
        }catch(IOException e) {
        	e.printStackTrace();
        }//End Make Manifest

		/*try{
			//this.file.write(this.JSONPersist.toString());
			//this.file.flush();
			//this.file.close();
			
			System.out.println("------------------------------------------");

			System.out.println("\nJSON Object: " + this.JSONPersist.toString());
		} catch(IOException e){
			e.printStackTrace();
		}finally {
			/*
			try{file.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}
			try{file.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			if (file!=null) {
				try {
					this.file.flush();
					this.file.close();
				}catch (IOException e) {
					//report exception
				}
			}
		} */
		}
        //End make manifest
	
	
	
	
	@SuppressWarnings("null")
	public static void main(String [] args) throws JSONException {
        int vertices,counter = 0;
        int source,destination,weight;
        final int source_vertex =0;
        LocalDate shipdate = LocalDate.now();
        FileWriter file=null;
        vertices=7;
        String parse,oNum="";
        Deliveries graph = new Deliveries(vertices);
        
        /* Code for JSON debugging begins here*/
		//JSONObject obj = new JSONObject();
		//obj.put(" "+shipdate+" Route",0);
		//obj.put("One", 1);
		//obj.put("Two", 2);
		//obj.put("Three", 3);
		//JSONArray deliveries = new JSONArray();
		//deliveries.put("Compnay: eBay");
		//deliveries.put("Compnay: Paypal");
		//deliveries.put("Compnay: Google");
		//obj.put(" "+shipdate+" Route", deliveries);
		

        //final int incrementer =5;
        /**
       
        final String quit="quit!";
        Scanner input = new Scanner(System.in);
        System.out.println("How many deliveries?");
        System.out.println("Reminder: Minimum deliveries are three.");
        parse = input.nextLine();
        vertices = Integer.valueOf(parse);
        
       
        
        //Testing Add Edge and route finding algorithm
        do{
        	System.out.println("Location: "+(counter+1));
        	
        	System.out.println("Enter the Order Number: \n" );
        	parse = input.nextLine();
        	oNum = parse;
        	
        	System.out.println("Enter the source: \n" );
        	parse = input.nextLine();
        	

                source = Integer.valueOf(parse);
        		
        		System.out.println("Enter the destination: \n");
                parse = input.nextLine();
                destination = Integer.valueOf(parse);
                
        		System.out.println("Enter the weight: \n");
                parse = input.nextLine();
                weight = Integer.valueOf(parse);
                
        		//graphInput.addEdge(source, destination, weight);
                graph.addOrder(oNum,source, destination, weight);
        		//graphInput.find_Route(source_vertex);
                counter++;
        }while(counter<vertices);
        //graphInput.find_Route(source_vertex);
         * 
         */
        //graph.addOrder(oNum,source, destination, weight);
        
        graph.addOrder("one",0, 1, 4);
        graph.addOrder("two",0, 2, 3);
        graph.addOrder("three",0, 2, 1);
        graph.addOrder("four",0, 3, 2);
        graph.addOrder("five",0, 3, 4);
        graph.addOrder("six",0, 4, 2);
        graph.addOrder("seven",0, 5, 6);

        graph.find_Route(source_vertex);
        Deliveries graph2 = new Deliveries(vertices);
        

        graph2.addOrder("five",0, 3, 4);
        graph2.addOrder("six",0, 4, 2);
        graph2.addOrder("seven",0, 5, 6);
        graph2.addOrder("one",0, 1, 4);
        graph2.addOrder("two",0, 2, 3);
        graph2.addOrder("three",0, 2, 1);
        graph2.addOrder("four",0, 3, 2);
        graph2.find_Route(source_vertex);
        Deliveries graph3 = new Deliveries(vertices);
        
        /* Only use full initialization for now
         * Passing orders as Order objects into the Graph's orders vector 
         * is not finding distance
         * 
         * */
        //Order o1,o2,o3,o4,o5,o6,o7 = null;
        //o1 = new Order("five",0, 3, 4);
       // o2 = new Order("six",0, 4, 2);
       // o3 = new Order("seven",0, 5, 6);
       // o4 = new Order("one",0, 1, 4);
       // o5 = new Order("two",0, 2, 3);
       // o6 = new Order("three",0, 2, 1);
       // o7 = new Order("four",0, 3, 2);
       // graph3.addOrder(o1 );
       // graph3.addOrder(o2);
       // graph3.addOrder(o3 );
       // graph3.addOrder(o4 );
       // graph3.addOrder(o5 );
       // graph3.addOrder(o6);
        //graph3.addOrder(o7 );
        /* 
         * makeManifest()
         * Inits a JSON object and creates a text file for use with the site.
         * */
        graph3.addOrder("five",0, 3, 4);
        graph3.addOrder("six",0, 4, 2);
        graph3.addOrder("seven",0, 5, 6);
        graph3.addOrder("one",0, 1, 4);
        graph3.addOrder("two",0, 2, 3);
        graph3.addOrder("three",0, 2, 1);
        graph3.addOrder("four",0, 3, 2);
        graph3.find_Route(source_vertex);
        graph3.makeManifest();
        /*
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.find_Route(0);
		*/
        
        /* 
         * Old debug code for writing to JSON file
         * 
         * Code for writing to JSON file begins here*/
        /* Current JSON file idea:
         * All delivery files are of the format:
         * Deliveries YYYY-MM-DD.txt //ex: "Deliveries 2018-11-30.txt"
         * Using shipdate to get date for delivery manifest name.
         * 
         * */
       
        /*
		try{file = new FileWriter("Deliveries "+shipdate+".txt");
		file.write(obj.toString());
		file.flush();
		System.out.println("------------------------------------------");
		System.out.println("Successfully Copied JSON Object to File...");
		System.out.println("\nJSON Object: " + obj);
	} catch(IOException e){
		e.printStackTrace();
	}finally {
		
		try{file.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
		try{file.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		if (file!=null) {
			try {
				file.close();
			}catch (IOException e) {
				//report exception
			}
		}
	}
	}*/

}}
