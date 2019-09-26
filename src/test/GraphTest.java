package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Edge;
import model.Graph;

class GraphTest {
	
	private Graph graph;
	
	@BeforeEach
	public void setUpData() {
		String[] rawData = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2",
				"EB3", "AE7", "AC1"};
		graph = new Graph(rawData);
	}

	@Test
	public void testLowestPathEdge() {
		assertTrue(graph.getLowestPathEdge("A", "C").equals(new Edge("A", "C", 1)));
	}
	
	@Test
	public void testAddInformation() {
		graph.addVertex("J");
		graph.addEdge("J", "A", 8);
		assertTrue(graph.getLowestPathEdge("J", "A").equals(new Edge("J", "A", 8)));
		
		graph.addEdge("J", "A", 4);
		assertTrue(graph.getLowestPathEdge("J", "A").equals(new Edge("J", "A", 4)));
	}
	
	

}
