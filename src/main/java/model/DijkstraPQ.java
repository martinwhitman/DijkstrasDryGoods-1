package model;
import javafx.util.Pair;
import model.DijkstraPQ.Order;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;
import java.util.stream.*;
import org.javatuples.Triplet; 
//update
public class DijkstraPQ{
	/**
	 * This should be noted that I understand that I 
	 * have numerous examples of bad programming 
	 * practices here; I am attempting to get as 
	 * much done and tested as fast as possible.
	 * 
	 * This unfortunately means I'm breaking some
	 * protocols.
	 * 
	 * Implementation based on code provided from:
	 * Tutorial Horizon, Algorithms
	 * algorithms.tutorialhorizon.com
	 * https://algorithms.tutorialhorizon.com/dijkstras-shortest-path-algorithm-spt-adjacency-list-and-priority-queue-java-implementation/
	 * 
	 * */
	
    static class Edge {
    	/**
    	 * Important class for the route finding algorithm
    	 * 
    	 * 
    	 * */
        int source;
        int destination;
        int weight;
        //int distance;
        
        

        public Edge(int source, int destination, int weight) {
            this.setSource(source);
            this.setDestination(destination);
            this.setWeight(weight);
        }



		public int getSource() {
			return source;
		}

		public void setSource(int source) {
			this.source = source;
		}



		public int getDestination() {
			return destination;
		}



		public void setDestination(int destination) {
			this.destination = destination;
		}



		public int getWeight() {
			return weight;
		}



		public void setWeight(int weight) {
			this.weight = weight;
		}



		@Override
		public String toString() {
			return "Edge [source=" + String.valueOf(this.getSource()) + ", destination=" + String.valueOf(this.getDestination()) + ", weight=" + String.valueOf(this.getWeight()) + "]";
		}
        
    }
    static class OrderLocation{
    	/**
    	 * portion related to the Edge class from
    	 * The Route Finding method
    	 * Part of the returned ordered list
    	 * for delivery orders
    	 * 
    	 * */
    	Edge location;
    	
    	public OrderLocation(Integer source,Integer destination, Integer weight) {
    		Edge edge = new Edge(source,destination,weight);
    		this.location = edge;
    	}
    	public OrderLocation(Edge loc) {
    		this.setOrderLocation(loc);
    	}
    	public void setOrderLocation(Edge oloc) {
    		this.location = oloc;
    	}
    	public Edge getOrderLocation() {
    		return this.location;
    		
    	}
    	
    }
    static class OrderNumber{
    	/**
    	 * Order Number portion
    	 * Part of the returned ordered list
    	 * for delivery orders
    	 * 
    	 * */
    	String orderNumber;
    	//Set<String, orderLocation>[] orderList;
    	
    	public OrderNumber(String oNumber) {
    		this.setOrderNumber(oNumber);
    		//this.orderLocation= oLoc;
    	}
    	public void setOrderNumber(String oNum) {
    		this.orderNumber = oNum;
    	}
    	public String getOrderNumber() {
    		return this.orderNumber;
    		
    	}
    	@Override
    	public String toString() {
    		return this.getOrderNumber();
    	}
    	
    }
    //<OrderNumber,OrderLocation>
    static class Order implements Comparable<Order>, Iterable <Order>{
    	final Integer SOURCE = 0;
    	OrderNumber oNum;
    	OrderLocation oLoc;
    	Integer distance; //position in delivery
    	
    	//debugging, do not use
    	/**
    	public String toString() {
    		String output="";
    		output= "Order: "+String.valueOf(this.getoNum().toString())+" Location: "+String.valueOf(this.getoLoc().getOrderLocation().toString())+" ";
    		
    		return output;
    	}*/
    	public Order(String num,
    			Integer source,
    			Integer destination,
    			Integer weight
    			){	
    		
    		OrderNumber newNum = new OrderNumber( num);
    		OrderLocation newLoc = new OrderLocation(source,destination,weight);
    		this.setoNum(newNum);
    		this.setoLoc(newLoc);
    		
    		
    	}
	    public Iterator<Order> iterator() {
	        return this.iterator();
	    }
	    /*
	     * Alternate constructor
	     * assumes source is base
	     * 
	     * */
    	public Order(String number, int destination, int weight) {
    		OrderNumber thisNumber = new OrderNumber(number);
    		Edge  thisEdge = new Edge(this.SOURCE, destination, weight);
    		
    		
    	}
	    
    	public Order(OrderNumber num,OrderLocation loc) {
    		this.setoNum(num);
    		this.setoLoc(loc);
    		
    	}
        public int compareTo(Order sequence) {
            return distance.compareTo(sequence.distance);
        }

		public OrderNumber getoNum() {
			return oNum;
		}

		public void setoNum(OrderNumber oNum) {
			this.oNum = oNum;
		}

		public OrderLocation getoLoc() {
			return oLoc;
		}

		public void setoLoc(OrderLocation oLoc) {
			this.oLoc = oLoc;
		}

		public Integer getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Order Number: "+ this.getoNum()+" Location: "+this.getoLoc().getOrderLocation().toString()+" ";
		}

    	
    	
    }
    
    static class Graph {
    	/**
    	 * Important class for the route finding algorithm
    	 * Adjustments have been made to keep track
    	 * of Orders for returning to customer/service team
    	 * 
    	 * */
        int vertices,listSize;
        final int LOC_COUNT=1;
        Vector<Order> orderSequence;
        final Integer SOURCE=0;

        //PriorityQueue <Pair <OrderNumber,OrderLocation>> orderthing;
        
        //final int MEMORY_SIZE = 2; // extending length of Adjacency List
        //int listSize; //= vertices*MEMORY_SIZE;
        //vertices =*MEMORY_SIZE;
        //LinkedList<Edge>[] adjacencylist;
        //LinkedList<Edge>[] adjacencylist;
        LinkedList<Order>[] adjacencylist;
        Vector<Order>orders; 
        //LinkedList<Order>[] orders;
        Graph(int vertices) {
            this.vertices = vertices;
            this.listSize = vertices;//*MEMORY_SIZE;
            adjacencylist = new LinkedList[vertices];
            orderSequence = new Vector();
            orders = new Vector(); 
           //public void set
            //vertices, new Comparator<Pair<Integer, Integer>
            
            //this.order = new PriorityQueue<>();
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<Order>();
            }
        }
        public void addOrder(String orderNumber,int source, int destination, int weight) {
        //addEdge(source,destination,weight);
        Edge edge = new Edge(source,destination,weight);
        OrderNumber oNum = new OrderNumber(orderNumber);
        OrderLocation oLoc = new OrderLocation(edge);
        Order order = new Order (oNum,oLoc);
        //System.out.println(oNum.toString());
        //System.out.println(oLoc.getOrderLocation().toString());
        orders.add(order);
        //System.out.println("Order Added: "+ orders.lastElement().toString());
        //addEdge(source,destination,weight);
        addEdge(order);
        }
		public void addOrder(Order incomingOrder) {
			orders.addElement(incomingOrder);
			System.out.println("Order Added.");
		}

        //public void addEdge(int source, int destination, int weight) {
        /**public void addEdge(Edge edge) {
            //Edge edge = new Edge(source, destination, weight);
            adjacencylist[edge.getSource()].addFirst(edge);
            
            //System.out.println("Size of Adjacency List: "+adjacencylist.length);
            edge = new Edge(edge.getDestination(), edge.getSource(), edge.getWeight());
            adjacencylist[edge.getDestination()].addFirst(edge); //for undirected graph
        }*/
        public void addEdge(Order order) {
        	/**Using an Adjacency List using type Order for maintaining connection to order number
        	 * */
            //Edge edge = new Edge(source, destination, weight);
            adjacencylist[order.getoLoc().getOrderLocation().getSource()].addFirst(order);
            
            //System.out.println("Size of Adjacency List: "+adjacencylist.length);
            OrderNumber tracking = new OrderNumber(order.getoNum().getOrderNumber());
            Edge edge= new Edge(order.getoLoc().getOrderLocation().getDestination(),order.getoLoc().getOrderLocation().getSource(),order.getoLoc().getOrderLocation().getWeight());
            OrderLocation location = new OrderLocation(edge);
            order = new Order(tracking,location );
            adjacencylist[edge.getDestination()].addFirst(order); //for undirected graph
        }
        
        //public static Vector<Orders> sortSequence(vector<Orders> sequenceIn)

        public void find_Route(int sourceVertex){

            boolean[] SPT = new boolean[vertices];
            //distance used to store the distance of vertex from a source
            int [] distance = new int[vertices];

            //Initialize all the distance to infinity
            for (int i = 0; i <vertices ; i++) {
            	//distance[i] = this.listSize;
                distance[i] = Integer.MAX_VALUE;
                
            }
            /**
             * Attempting to use triplet for order indexing during Route Find
             * */
            //Initialize priority queue
            //override the comparator to do the sorting based keys
           // PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() {
            PriorityQueue<Triplet<Integer, Integer, String>> pq = new PriorityQueue<Triplet<Integer, Integer, String>>(vertices, new Comparator<Triplet<Integer, Integer,String>>() {   
            @Override
            	public int compare(Triplet<Integer, Integer, String> p1, Triplet<Integer, Integer,String> p2) {
                    //sort using distance values
                    int key1 = p1.getValue0();
                    int key2 = p2.getValue0();
                    return key1-key2;
                }
            });
            //create the pair for for the first index, 0 distance 0 index
            distance[0] = 0;
            Triplet<Integer, Integer,String> p0 = new Triplet<Integer, Integer, String>(distance[0],0,"Source");
            //add it to pq
            pq.offer(p0);
            /**Debug variable to verify that algorithm is running
             * 
             * 
             * */
            //Triplet<Integer, Integer,String> debug;
            //while priority queue is not empty
            // Graph's Order priority queue is filled with members to be sorted
        
            while(!pq.isEmpty()){
                //extract the min
                Triplet<Integer, Integer,String> extractedPair = pq.poll();
                //debug=extractedPair;
                 //System.out.println(debug.getValue2());
                //this.order.add(extractedPair);
                //extracted vertex
                int extractedVertex = extractedPair.getValue1();
                //String extractedNumber = extractedPair.getValue2();
                if(SPT[extractedVertex]==false) {
                    SPT[extractedVertex] = true;

                    //iterate through all the adjacent vertices and update the keys
                    LinkedList<Order> list = adjacencylist[extractedVertex];
                    for (int i = 0; i < list.size(); i++) {
                    	System.out.println("Order in pos :"+i+" item: "+list.get(i).toString()+" of "+list.size());
                        /**Edge edge = list.get(i);*/
                        Order order = list.get(i);
                        Order orderCopy = new Order(order.getoNum(),order.getoLoc()); 
                        int destination = order.getoLoc().getOrderLocation().getDestination();
                        String orderNumber = order.getoNum().getOrderNumber();
                        //only if edge destination is not present in mst
                        if (SPT[destination] == false) {
                            ///check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance
                            int newKey =  distance[extractedVertex] + order.getoLoc().getOrderLocation().getWeight() ;
                            int currentKey = distance[destination];
                            String currentOrder = orderNumber;
                            //System.out.println("Distance: "+distance[destination]);
                            //System.out.println("Distance of new Key: "+newKey);
                            System.out.println("PQ: "+pq.toString());
                            if(currentKey<newKey){
                            	Triplet<Integer, Integer,String> q = new Triplet<Integer, Integer, String>(currentKey, destination,currentOrder);
                            	//Edge thisEdge = new Edge (q.getValue(0), q.getValue(1));
                            	//OrderLocation =(SOURCE, thisEdge);
                            	//Order  thisOrder = new Order(q.getValue(2),thisEdge);
                            	order.setDistance(currentKey);
                            	pq.offer(q);
                            	System.out.println("PQ Q set: "+pq.toString());
                            	orderSequence.addElement(order);
                            	

                                
                                //System.out.println("Distance of new Key: "+distance[newKey]);
                            }else if(currentKey>newKey){
                                Triplet<Integer, Integer,String> p = new Triplet<Integer, Integer, String>(newKey, destination,currentOrder);
                                order.setDistance(newKey);
                                pq.offer(p);
                                System.out.println("PQ P set: "+pq.toString());
                                orderSequence.addElement(order);
                                distance[destination] = newKey;
                            	//orderSequence.addElement(orderCopy);
                            }
                        }
                    }
                }
            }
            //print Shortest Path Tree
            /*Sort Order Sequence list by distances by calling Java.Util.Collections sort() method*/
            /*Honestly, this should be its own method, if not helper method to Graph.*/
            /**/
            Collections.sort(orderSequence);
            printDijkstra(distance, sourceVertex);
         
           /** while(!pq.isEmpty()) {
            	System.out.println(pq.toString());
            }*/
            //for(Order o: orders) {
            //System.out.println(" Order: "+o );
            //}
           /** for (Order o: orders) {
            System.out.println("Orders: "+ o.getoNum().toString());
            }*/
            /**Attempting to work with Streams, so far bad idea
            				List<Order> outGoing=
            					orders
            					.build()
            					.collect(Collectors.toList());
            				outGoing.a
            				//outGoing.forEach(order->System.out.println(order.toString()));
            				for (Order o : orders.build().collect(Collectors.)) {
            					System.out.println(" Order Number: "
            				+o.getoNum()
            				+" "
            				+o.getoLoc());
            				}
            */
            					
            
        }

        public void printDijkstra(int[] distance, int sourceVertex){
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            //create "if" to set if source = 0 then set print to home.
            for (int i = 0; i <vertices ; i++) {
            	//For original Dijkstra output:
                //System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + (i+this.LOC_COUNT) +
                //        " distance: " + distance[i]);
            	//this seems to be wrong, lists are not updated.
                System.out.println("Distance from center to location: " +   + (i+this.LOC_COUNT) +
                        " distance: " + distance[i]);
                
                System.out.println(this.orders.elementAt(i));
                System.out.println(this.orders.elementAt(i).getoNum().getOrderNumber());
                System.out.println(this.orders.elementAt(i).getDistance());



            }            
            System.out.println("Order Sequence Vector: ");   
            System.out.println(this.orderSequence.toString());
            
        }

        public static void main(String[] args) {
            int vertices = 6;
            Graph graph = new Graph(vertices);
        /** 
         * 
         *    
         *    graph.addEdge(0, 1, 4);
            graph.addEdge(0, 2, 3);
            graph.addEdge(1, 2, 1);
            graph.addEdge(1, 3, 2);
            graph.addEdge(2, 3, 4);
            graph.addEdge(3, 4, 2);
            graph.addEdge(4, 5, 6);*/
        }
    }
}





