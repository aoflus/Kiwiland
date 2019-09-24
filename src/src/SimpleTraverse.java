package src;

import model.Graph;

public class SimpleTraverse {
	
	private Graph graph;

	public SimpleTraverse(Graph graph) {
		this.graph = graph;
	}
	
	private int getPathSize(String start, String end) {
		return graph.getLowestPathEdge(start, end).getWeigth();
	}
	
	public int getFullPathSize(String path) {
		int pathSum = 0;
		String[] route = path.split("-");
		try {
			for (int i = 1; i < route.length; i++) {
				pathSum += getPathSize(route[i-1], route[i]);
			}
			return pathSum;
		}
		catch (NullPointerException e){ 
			
		}
		return -1;
	}
}
