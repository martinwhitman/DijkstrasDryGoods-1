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
//update
public class Deliveries extends Graph{
	
	

	
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

	
	}
	
	
	
	//Vertices here are known as Locations
	
	Deliveries(int locations) {
		//Locations determines how many stops there are to make
		super(locations);
		//Int represents order placement, ergo priority
		
		
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
		JSONObject obj = new JSONObject();
		obj.put(" "+shipdate+" Route",0);
		obj.put("One", 1);
		obj.put("Two", 2);
		obj.put("Three", 3);
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
        
        /* Code for writing to JSON file begins here*/
        /* Current JSON file idea:
         * All delivery files are of the format:
         * Deliveries YYYY-MM-DD.txt //ex: "Deliveries 2018-11-30.txt"
         * Using shipdate to get date for delivery manifest name.
         * 
         * */
		try{file = new FileWriter("Deliveries "+shipdate+".txt");
		file.write(obj.toString());
		file.flush();
		System.out.println("Successfully Copied JSON Object to File...");
		System.out.println("\nJSON Object: " + obj);
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
		}*/
		if (file!=null) {
			try {
				file.close();
			}catch (IOException e) {
				//report exception
			}
		}
	}
	}

}
