package data;

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
	
	@Override
	public int compareTo(Edge e) {
		return (this.weight > e.weight) ? 1 : (this.weight == e.weight) ? 0 : -1;
	}
	
	@Override
	public boolean equals(Object obj) {
		Edge edge = (Edge) obj;
		if (this.getFrom().equals(edge.getFrom())
				&& this.getTo().equals(edge.getTo())
				&& this.getWeigth() == edge.getWeigth()) {
			return true;
		}
		return false;
	}
}
