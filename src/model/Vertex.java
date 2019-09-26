package model;

/**
 * Edge class to store the information of each of the given cities.
 * The name of the city is stored in a city variable that can be publicly
 * accessed using the getName method.
 */
public class Vertex {
	
	private String name;
	
	public Vertex(String name) { this.name = name;}
	public String getName() {return this.name;}
	
	/**
	 * The hashCode function hashes the name of the vertex. This function
	 * is needed in order to operate with the vertex as key values in the
	 * adjacency list on the graph.
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * The equals method for the Vertex class compares the names of both 
	 * vertexes.
	 *
	 * @return True if both characters are the same. False otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vertex)) {
			return false;
		}
		return this.getName().equals(((Vertex) obj).getName());
	}
}
