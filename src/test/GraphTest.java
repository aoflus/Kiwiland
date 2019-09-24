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
	
	private List<String> graphData;
	
	@BeforeEach
	public void setUpData() {
		String[] rawData = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7", "AC1"};
		graphData = new ArrayList<String>();
		graphData.addAll(Arrays.asList(rawData));
	}

	@Test
	public void testCreateGraphWithInitialData() {
		//Graph graph = new Graph(graphData);
		
	}
	
	@Test
	public void testLowestPathEdge() {
		//Graph graph = new Graph(graphData);
		//assertTrue(graph.getLowestPathEdge("A", "C").equals(new Edge("A", "C", 1)));
	}

}
