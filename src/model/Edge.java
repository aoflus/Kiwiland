package model;

/**
 * Edge class to store the information of each of the given paths that connect the cities.
 * It contains the name of the two cities that are connected.
 * The weight of the edge is stored in a weight property.
 */
public class Edge implements Comparable<Edge> {
	
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
	
	/**
	 * The compare interface implementation defines its comparison based on
	 * the weight value of each edge. As java checks the sign of the return
	 * value rather than the numeric value, it's easier to read and faster 
	 * to compute to just return the result of the minus operation.
	 *
	 * @return Positive value if self edge weight is bigger, negative value
	 * if the foreigner edge weight is bigger, 0 if both have the same weight
	 */
	@Override
	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}
	
	/**
	 * The equals implementation for the Edge class compares for a pair
	 * of edges the Character representing the starting city, the character
	 * representing the ending city, and the length of the path.
	 * 
	 * @return True if all 3 of the attributes are the same. False otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		/* instance check to avoid invalid format exceptions*/
		if (!(obj instanceof Edge)) { 
			return false;
		}
		
		Edge edge = (Edge) obj;
		if (this.getFrom().equals(edge.getFrom())
				&& this.getTo().equals(edge.getTo())
				&& this.getWeigth() == edge.getWeigth()) {
			return true;
		}
		return false;
	}
}
