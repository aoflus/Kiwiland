package main;

import model.Graph;
import src.InputParser;

public class Main {
	
	private static InputParser parser;
	
	public static void main (String... args) {
		parser = new InputParser();
		for (String arg : args) {
			switch(arg.charAt(0)) {
			case '-':
				
			break;
			default:
				execute();
			break;
			}
		}
	}
	
	public static void execute() {
		String rawData = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		String[] data = parser.parseData(rawData);
		Graph graph = new Graph(data);
	}
	
	public static void execute(String rawData) {
		String[] data = parser.parseData(rawData);
		Graph graph = new Graph(data); 
	}
}