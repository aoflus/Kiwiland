package main;

import model.Graph;
import src.Utils;
import src.SimpleTraverse;

public class Main {
	
	private static Utils utils;
	private static SimpleTraverse st;
	
	public static void main (String... args) {
		String[] options = parseArguments(args);
		utils = new Utils();
		if (options[0] == null && options[1] == null) {
			execute();
		} else if (options[0] == null || options[1] == null) {
			throw new IllegalArgumentException("Expected two arguments but"
					+ "only received 1");
		} else {
			execute(options);
		}
		
	}
	
	/*
	 * Argument parser. Right now, the program accepts either NO arguments or
	 * 2 arguments, but no other combination whatsoever. The 2 arguments are
	 * the following:
	 *  -d: stands for DATA, a String of 3 character nodes, comma separated,
	 *  meaning the starting city, the ending city and the weight of the path
	 *  between them.
	 *
	 *  -p: stands for PATHS, a String of character sequences, comma separated,
	 *  meaning the paths the algorithm must traverse and evaluate. Each path
	 *  is composed by a series of characters separated by '-'.
	 */
	private static String[] parseArguments(String[] args) {
		String[] options = new String[2];
		if (args[0] == null) { // check for no arguments
			return options;
		}
		
		// Parse arguments into options array
		for (int i = 0; i < args.length; i++) {
			
			switch(args[i].charAt(0)) {
				case '-': // argument
					if (args[i].length() < 2) {
						throw new IllegalArgumentException(
								"Not a valid argument: " + args[i]);
					} else if (args[i].charAt(1) != 'p' &&
							args[i].charAt(1) != 'd') {
						throw new IllegalArgumentException(
								"Not a valid argument: " + args[i]);
					} else if (args.length-1 == i) {
						throw new IllegalArgumentException(
								"Expected argument after " + args[i]);
					} else { // valid argument
						if (args[i].charAt(1) == 'd') {
		                	options[0] = args[i+1]; // position 0 -> data
						} else {
		                	options[1] = args[i+1]; // position 1 -> paths
						}
		                i++;
					}
				break;
				default:
				break;
			}
		}
		return options;
	}
	
	/*
	 * Standard execution, without parameters. When this execution is
	 * triggered, the program uses the input graph set and the paths given
	 * on the example.
	 */
	public static void execute() {
		String rawData = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
		String rawPaths = "A-B-C, A-D, A-D-C, A-E-B-C-D, A-E-D";
		
		String[] data = utils.parseData(rawData);
		Graph graph = new Graph(data);
		st = new SimpleTraverse(graph);
		
		String[] paths = utils.parsePath(rawPaths);
		for (String path : paths) {
			int value = st.getFullPathSize(path);
			System.out.println(value == -1 ? "NO SUCH ROUTE" : value);
		}
	}
	
	/*
	 * Execution with arguments. When this execution is triggered, the program
	 * uses the arguments input made by the user when invocating the program.
	 */
	public static void execute(String[] options) {
		String[] data = utils.parseData(options[0]);
		Graph graph = new Graph(data);
		st = new SimpleTraverse(graph);
		
		String[] paths = utils.parsePath(options[1]);
		for (String path : paths) {
			int value = st.getFullPathSize(path);
			System.out.println(value == -1 ? "NO SUCH ROUTE" : value);
		}
	}
}