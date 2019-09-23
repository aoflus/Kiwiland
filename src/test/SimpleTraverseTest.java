package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.SimpleTraverse;
import data.Graph;

class SimpleTraverseTest {
	
	private List<String> graphData;
	private Graph graph;
	private SimpleTraverse traverse;

	@BeforeEach
	public void setUp() {
		String[] rawData = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
		graphData = new ArrayList<String>();
		graphData.addAll(Arrays.asList(rawData));
	}
	
	@Test
	void testTraverse() {
		graph = new Graph(graphData);
		traverse = new SimpleTraverse(graph);
		
		assertTrue(traverse.getFullPathSize("A-B-C") == 9);
		assertTrue(traverse.getFullPathSize("A-D") == 5);
		assertTrue(traverse.getFullPathSize("A-D-C") == 13);
		assertTrue(traverse.getFullPathSize("A-E-B-C-D") == 22);
		assertTrue(traverse.getFullPathSize("A-E-D") == -1);
		
	}

}
