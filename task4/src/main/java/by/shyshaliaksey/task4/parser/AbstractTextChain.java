package by.shyshaliaksey.task4.parser;

import java.util.regex.Pattern;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TerminalElementLeaf;
import by.shyshaliaksey.task4.exception.TextException;

public abstract class AbstractTextChain {

	private static final String DIGITS = "\\d";
	private static final String PUNCTUATION_MARKS = "\\p{Punct}"; 
	private static final String LETTERS = "\\p{Alpha}";
	
	protected AbstractTextChain nextInChain;
	
	public void setNextInChain(AbstractTextChain nextInChain) {
		this.nextInChain = nextInChain;
	}

	public abstract void parse(AbstractComponent parentComponent, String contentToParse) throws TextException;

	protected void parseSymbols(AbstractComponent component, String stringToParse) {
		if (stringToParse != null) {
			for (char symbol : stringToParse.toCharArray()) {
				ComponentType componentType = ComponentType.SYMBOL;
				String characterString = Character.toString(symbol);
				if (Pattern.matches(LETTERS, characterString)) {
					componentType = ComponentType.LETTER;
				} else if (Pattern.matches(DIGITS, characterString)) {
					componentType = ComponentType.DIGIT;
				} else if (Pattern.matches(PUNCTUATION_MARKS, characterString)) {
					componentType = ComponentType.PUNCTUATION_MARK;
				}
				component.add(new TerminalElementLeaf(componentType, component, symbol));
			}
		}
	}
	
}
