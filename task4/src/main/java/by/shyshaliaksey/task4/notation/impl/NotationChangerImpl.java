package by.shyshaliaksey.task4.notation.impl;

import java.util.ArrayDeque;
import java.util.Deque;

import by.shyshaliaksey.task4.notation.NotationChanger;

public class NotationChangerImpl implements NotationChanger {

	private static final String EMPTY_STRING = "";
	private static final String SPACE = " ";
	private static final String DIGITS = "0123456789";
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
	private Deque<String> deque;
	private boolean operationPrevious;
	private boolean previousDigit;
	private StringBuilder builder;
	
	public NotationChangerImpl() {
		deque = new ArrayDeque<>();
		builder = new StringBuilder();
	}
	
	@Override
	public String normalToPrefix(String normalForm) {
		String[] arrayToChange = setup(normalForm).split(EMPTY_STRING);
		for (String symbol: arrayToChange) {
			if (symbol.equals(UNARY_NOT)) {
				operationPrevious = true;
				deque.push(symbol);
			} else if (symbol.equals(OPEN_BRACKET)) {
				deque.push(symbol);
			} else if (symbol.equals(CLOSE_BRACKET)) {
				while (!deque.peek().equals(OPEN_BRACKET)) {
					builder.append(SPACE + deque.pop());
				}
				deque.pop();
			} else if (isSymbolDigit(symbol)) {
				digitProcessing(symbol);
			}  else if (getPriority(symbol) != -1) {
				operationProcessing(symbol);
			}
		}
		popAllSymbols();
		return builder.toString();
	}
	
	private void popAllSymbols() {
		while (!deque.isEmpty()) {
			builder.append(SPACE + deque.pop());
		}
	}
	
	private void digitProcessing(String symbol) {
		previousDigit = true;
		if (operationPrevious) {
			builder.append(SPACE);
			operationPrevious = false;
		}
		builder.append(symbol);
	}
	
	private void operationProcessing(String symbol) {
		if (previousDigit && !deque.isEmpty() && deque.peek().equals(UNARY_NOT)) {
			builder.append(SPACE + deque.pop());
		}
		previousDigit = false;
		operationPrevious = true;
		if (deque.isEmpty()) {
			deque.push(symbol);
			return;
		}
		while (getPriority(deque.peek()) > getPriority(symbol)) {
			builder.append(SPACE + deque.pop());
			if (deque.isEmpty()) {
				break;
			}
		}
		deque.push(symbol);
	}
	
	private boolean isSymbolDigit(String symbol) {
		return DIGITS.contains(symbol);
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
