package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Graph class that stores the input graph
 */
public class Graph {
	
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
			if (input.length() != 3) {
				throw new IllegalArgumentException("The data provided is not on the correct format");
			}
			addVertex(input.substring(0,1));
			addEdge(input.substring(0,1),
					input.substring(1,2), 
					Integer.parseInt(input.substring(2,3)));
		}
	}
	
	public Map<Vertex, List<Edge>> getAdjacencyList() {
		return this.adjacencyList;
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
	
	/**
	 * Returns the list of adjacent edges to a specific given vertex.
	 *
	 * @param name The name of the vertex
	 * @return a List of edges containing all the adjacent edges to that vertex
	 */
	public List<Edge> getAdjacentEdges(String name){
		return adjacencyList.get(new Vertex(name));
	}
	
	/**
	 * Utility method that given the name of two vertex returns either the lowest
	 * of the paths connecting the two edges or null;
	 *
	 * @param from The name of the starting point vertex
	 * @param to The name of the ending point vertex
	 * @return The edge with the smallest weight if exists. Null otherwise
	 */
	public Edge getLowestPathEdge(String from, String to) {
		List<Edge> paths = adjacencyList.get(new Vertex(from)).stream()
				.filter(path -> path.getTo().equals(to))
				.collect(Collectors.toList());
		return paths.isEmpty() ? null : Collections.min(paths);
	}
}
