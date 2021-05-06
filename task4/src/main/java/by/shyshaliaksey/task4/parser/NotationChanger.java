package by.shyshaliaksey.task4.parser;

import java.util.Stack;

public class NotationChanger {

	private static final String UNARY_NOT = "~";
	private static final String OPEN_BRACKET = "(";
	private static final String CLOSE_BRACKET = ")";
	private static final String LEFT_SHIFT = "<<";
	private static final String NEW_LEFT_SHIFT = "L";
	private static final String RIGHT_SHIFT = ">>";
	private static final String NEW_RIGHT_SHIFT = "R";
	private static final String UNSIGNED_RIGHT_SHIFT = ">>>";
	private static final String NEW_UNSIGNED_RIGHT_SHIFT = "U";
	private static final String AND = "&";
	private static final String XOR = "^";
	private static final String OR = "|";

	private Stack<String> stack = new Stack<>();
	
	public NotationChanger() {
	}

	// TODO implement
	public String normalToPrefix(String normalForm) {
		boolean operationPrevious = false;
		boolean previousDigit = false;
		String[] arrayToChange = setup(normalForm).split("");
		String outputString = "";
		for (String symbol: arrayToChange) {
			switch(symbol) {
			case UNARY_NOT:
				operationPrevious = true;
				stack.push(symbol);
				continue;
			case OPEN_BRACKET:
				stack.push(symbol);
				continue;
			case CLOSE_BRACKET:
				while (!stack.peek().equals(OPEN_BRACKET)) {
					outputString += " " + stack.pop();
				}
				stack.pop();
				continue;
			}
			if (isSymbolDigit(symbol)) {
				previousDigit = true;
				if (operationPrevious) {
					outputString += " ";
					operationPrevious = false;
				}
				outputString += symbol;
				continue;
			}
			if (getPriority(symbol) != -1) {
				if (previousDigit) {
					if (!stack.empty()) {
						if (stack.peek().equals(UNARY_NOT)) {
							outputString += " " + stack.pop();
						}
					}
				}
				previousDigit = false;
				operationPrevious = true;
				if (stack.empty()) {
					stack.push(symbol);
					continue;
				}
				
				while (getPriority(stack.peek()) > getPriority(symbol)) {
					outputString += " " + stack.pop();
					if (stack.empty()) {
						break;
					}
				}
				stack.push(symbol);
			}
		}
		while (!stack.isEmpty()) {
			outputString += " " + stack.pop();
		}
		return outputString;
	}
	
	private boolean isSymbolDigit(String symbol) {
		return "0123456789".contains(symbol);
	}
	
	private int getPriority(String symbol) {
		switch(symbol) {
		case NEW_LEFT_SHIFT:
			return 6;
		case NEW_RIGHT_SHIFT:
			return 5;
		case NEW_UNSIGNED_RIGHT_SHIFT:
			return 4;
		case AND:
			return 3;
		case XOR:
			return 2;
		case OR:
			return 1;
		default:
			return -1;
		}
	}
	
	private String setup(String stringToChange) {
		String result = stringToChange.replace(UNSIGNED_RIGHT_SHIFT, NEW_UNSIGNED_RIGHT_SHIFT);
		result = result.replace(LEFT_SHIFT, NEW_LEFT_SHIFT);
		result = result.replace(RIGHT_SHIFT, NEW_RIGHT_SHIFT);
		return result;
	}

}
