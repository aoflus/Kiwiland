package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Graph class that stores the input graph
 */
public class Graph {
	
	/**
	 * Edge class to store the information of each of the given cities.
	 * The name of the city is stored in a city variable that can be publicly accessed using
	 * the getName method.
	 */
	class Vertex {
		
		private String name;
		
		public Vertex(String name) { this.name = name;}
		public String getName() {return this.name;}
	}
	
	/**
	 * Edge class to store the information of each of the given paths that connect the cities.
	 * It contains the name of the two cities that are connected.
	 * The weight of the edge is stored in a weight property.
	 */
	class Edge implements Comparable<Edge> {
		
		private int weight;
		private String from;
		private String to;
		
		public Edge(String from, String to, int weight) {
			this.weight = weight;
			this.from = from;
			this.to = to;
			}
		
		public String getFrom() {return this.from;}
		public String getTo() {return this.to;}
		public int getWeigth() {return this.weight;}
		
		@Override
		public int compareTo(Edge e) {
			return (this.weight > e.weight) ? 1 : (this.weight == e.weight) ? 0 : -1;
		}
	}
	
	/* Private attributes declaration */
	private Map<Vertex, List<Edge>> adjacencyList;
	
	/**
	 * Empty constructor. Declares a new Graph by initializing the adjacencyList map.
	 */
	public Graph() {
		adjacencyList = new HashMap<>();
	}
	
	/**
	 * Constructor that declares a new graph given a set of initial data. The structure of
	 * the initial data must be a list of String elements, with 3 characters each, where 
	 * the first element refers to the origin city, the second one to the destination city
	 * and the last one to the weight of the connection between the cities.
	 *
	 * @param initialData A set of city connections
	 */
	public Graph(List<String> initialData) {
		adjacencyList = new HashMap<>();
		addInitialData(initialData);
	}
	
	private void addInitialData(List<String> initialData) {
		for (String input : initialData) {
			addVertex(input.substring(0,1));
			addEdge(input.substring(0,1),
					input.substring(1,2), 
					Integer.parseInt(input.substring(2,3)));
		}
	}
	
	/**
	 * Adds a new vertex to the graph in case it does not exist already.
	 * @param name The name of the city
	 */
	public void addVertex(String name) {
		adjacencyList.putIfAbsent(new Vertex(name),new ArrayList<Edge>());
	}
	
	/**
	 * Adds a new edge to the graph. The method gets the pair key, value based on
	 * the from String, and adds to the value array the new edge.
	 *
	 * @param from The origin city
	 * @param to The destination city
	 * @param weight The weight of the edge
	 */
	public void addEdge(String from, String to, int weight) {
		adjacencyList.get(new Vertex(from)).add(new Edge(from, to, weight));
	}
	
}
