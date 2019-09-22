package data;

/**
 * Edge class to store the information of each of the given cities.
 * The name of the city is stored in a city variable that can be publicly accessed using
 * the getName method.
 */
public class Vertex {
	
	private String name;
	
	public Vertex(String name) { this.name = name;}
	public String getName() {return this.name;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getName().equals(((Vertex) obj).getName());
	}
}
