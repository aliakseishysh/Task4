package by.shyshaliaksey.task4.parser;

import by.shyshaliaksey.task4.entity.AbstractComponent;
import by.shyshaliaksey.task4.entity.ComponentType;
import by.shyshaliaksey.task4.entity.TerminalElementLeaf;
import by.shyshaliaksey.task4.exception.TextException;

public abstract class AbstractTextChain {

	private static final String DIGITS = "0123456789";
	private static final String PUNCTUATION_MARKS = ".,-!?…"; 
	private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
	
	protected AbstractTextChain nextInChain;
	
	public void setNextInChain(AbstractTextChain nextInChain) {
		this.nextInChain = nextInChain;
	}

	public abstract void parse(AbstractComponent parentComponent, String contentToParse) throws TextException;

	protected void parseSymbols(AbstractComponent component, String stringToParse) {
		if (stringToParse != null) {
			for (char symbol : stringToParse.toCharArray()) {
				ComponentType componentType = ComponentType.SYMBOL;
				if (LETTERS.contains(Character.toString(symbol).toLowerCase())) {
					componentType = ComponentType.LETTER;
				} else if (DIGITS.contains(Character.toString(symbol))) {
					componentType = ComponentType.DIGIT;
				} else if (PUNCTUATION_MARKS.contains(Character.toString(symbol))) {
					componentType = ComponentType.PUNCTUATION_MARK;
				}
				component.add(new TerminalElementLeaf(componentType, component, symbol));
			}
		}
	}
	
}
