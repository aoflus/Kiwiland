package src;

public class Utils {
	
	public String[] parseData(String input) {
		return input.replace(" ","").split(",");
	}
	
	public String[] parsePath(String input) {
		return input.replace(" ", "").split(",");
	}
}
